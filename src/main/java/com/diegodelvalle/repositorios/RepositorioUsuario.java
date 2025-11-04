package com.diegodelvalle.repositorios;

import com.diegodelvalle.modelos.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombreUsuario);
}
