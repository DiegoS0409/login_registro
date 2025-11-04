package com.diegodelvalle.controladores;

import com.diegodelvalle.modelos.Usuario;
import com.diegodelvalle.servicios.ServicioUsuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLoginRegistro {

    private final ServicioUsuario servicioUsuario;

    public ControladorLoginRegistro(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuarioRegistro", new Usuario());
        model.addAttribute("usuarioLogin", new Usuario());
        return "index";
    }

    @PostMapping("/procesa/registro")
    public String registrar(@Valid @ModelAttribute("usuarioRegistro") Usuario usuario,
                            BindingResult result,
                            Model model) {

        if (!usuario.getContrasena().equals(usuario.getConfirmacionContrasena())) {
            result.rejectValue("confirmacionContrasena", "error.usuario", "Las contraseñas no coinciden");
        }

        if (servicioUsuario.existeUsuario(usuario.getNombreUsuario())) {
            result.rejectValue("nombreUsuario", "error.usuario", "El nombre de usuario ya existe");
        }

        if (result.hasErrors()) {
            model.addAttribute("usuarioLogin", new Usuario());
            return "index";
        }

        servicioUsuario.registrar(usuario);
        return "redirect:/inicio";
    }

    @PostMapping("/procesa/login")
    public String login(@ModelAttribute("usuarioLogin") Usuario usuario,
                        Model model) {

        boolean valido = servicioUsuario.login(usuario.getNombreUsuario(), usuario.getContrasena());

        if (!valido) {
            model.addAttribute("usuarioRegistro", new Usuario());
            model.addAttribute("errorLogin", "Usuario o contraseña incorrecta");
            return "index";
        }

        return "redirect:/inicio";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }
}
