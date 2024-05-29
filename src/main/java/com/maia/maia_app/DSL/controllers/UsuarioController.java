package com.maia.maia_app.DSL.controllers;

import com.maia.maia_app.DSL.models.Necesidad;
import com.maia.maia_app.DSL.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }

    @PostMapping("/formulario/enviar")
    public String procesarFormulario(@ModelAttribute Usuario usuario, Model model) {
        // Aquí puedes manejar la lógica para guardar los datos en XML utilizando JAXB
        // Por simplicidad, simplemente imprimiremos los datos del usuario y sus necesidades
        System.out.println(usuario);
        for (Necesidad necesidad : usuario.getNecesidades()) {
            System.out.println(necesidad);
        }
        return "confirmacion";
    }
}