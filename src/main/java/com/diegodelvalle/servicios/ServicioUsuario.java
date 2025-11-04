package com.diegodelvalle.servicios;

import com.diegodelvalle.modelos.Usuario;
import com.diegodelvalle.repositorios.RepositorioUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario {
    private final RepositorioUsuario repositorioUsuario;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario registrar(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return repositorioUsuario.save(usuario);
    }

    public boolean login(String nombreUsuario, String contrasena) {
        Usuario usuario = repositorioUsuario.findByNombreUsuario(nombreUsuario);
        if(usuario == null) return false;
        return passwordEncoder.matches(contrasena, usuario.getContrasena());
    }

    public boolean existeUsuario(String nombreUsuario) {
        return repositorioUsuario.findByNombreUsuario(nombreUsuario) != null;
    }
}
