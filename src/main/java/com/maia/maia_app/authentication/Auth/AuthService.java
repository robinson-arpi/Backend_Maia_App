package com.maia.maia_app.authentication.Auth;

import com.maia.maia_app.authentication.AuthJwt.JwtService;
import com.maia.maia_app.authentication.User.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode( request.getPassword()))
                .userRoles(new ArrayList<>())
                .registrations(new ArrayList<>())
                .build();

        Role role = roleRepository.findByRoleName(request.getRol());
        if (role == null) {
            throw new RuntimeException("Role don´t exist");
        }

        // Creamos un UserRole para el usuario
        UserRole userRoleEntity = new UserRole();
        userRoleEntity.setUser(user);
        userRoleEntity.setRole(role);

        // Agregamos el UserRole a la lista de roles del usuario
        user.getUserRoles().add(userRoleEntity);

        userRepository.save(user);
        userRoleRepository.save(userRoleEntity);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}