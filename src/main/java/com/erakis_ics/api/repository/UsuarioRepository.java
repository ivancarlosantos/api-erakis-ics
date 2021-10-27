package com.erakis_ics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erakis_ics.api.entity.Usuario;

/*  
 * @author by: icarlos 
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
