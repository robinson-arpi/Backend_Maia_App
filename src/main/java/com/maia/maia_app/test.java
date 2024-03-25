package com.maia.maia_app;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {

    public static void main(String[] args) {
        // Crear una instancia de PasswordEncoder (BCryptPasswordEncoder es una implementación comúnmente utilizada)
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Contraseña proporcionada por el usuario
        String contraseña = "admin";

        // Cifrar la contraseña
        String contraseñaCifrada = passwordEncoder.encode(contraseña);

        // Imprimir la contraseña cifrada
        System.out.println("Contraseña cifrada: " + contraseñaCifrada);
    }
}

