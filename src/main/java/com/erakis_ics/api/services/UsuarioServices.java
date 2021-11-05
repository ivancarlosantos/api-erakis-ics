package com.erakis_ics.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.dtos.UsuarioDTO;
import com.erakis_ics.api.entity.Usuario;
import com.erakis_ics.api.repository.UsuarioRepository;

/*  
 * @author by: icarlos 
 */

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario saveUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new RuntimeException("Usuário [" + usuario + "] não encontrado");
		}
			
		usuarioRepository.save(usuario);
		return usuario;
	}

	public Usuario findUsuarioByID(Long usr_id) {
		Optional<Usuario> findUsuarioByID = usuarioRepository.findById(usr_id);
		Usuario usuario = null;
		if (!findUsuarioByID.isPresent()) {
			throw new RuntimeException("Usuário com ID = [" + usr_id + "] " + HttpStatus.NOT_FOUND + " ");
		}
		usuario = findUsuarioByID.get();

		return usuario;
	}

	public List<UsuarioDTO> usuarioFindAll() {
		List<UsuarioDTO> listAll = usuarioRepository
								   .findAll()
								   .stream()
								   .map(usrDTO -> new UsuarioDTO(usrDTO))
								   .collect(Collectors.toList());
		return listAll;
	}

	public Usuario updateUsuario(Long usr_id, Usuario usuarioDTO) {
		Usuario usuario = findUsuarioByID(usr_id);
		usuario.setNome(usuarioDTO.getNome());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setSalt(usuarioDTO.getSalt());
		usuario.setUltimoLogin(usuarioDTO.getUltimoLogin());
		usuario.setAdministrador(usuarioDTO.isAdministrador());
		usuario.setBloqueado(usuarioDTO.isBloqueado());
		usuario.setLoginBloqueado(usuarioDTO.isLoginBloqueado());
		usuario.setCancelarBloqueado(usuarioDTO.getCancelarBloqueado());
		usuario.setEditarBloqueado(usuarioDTO.getEditarBloqueado());
		usuario.setPessoaFisica(usuarioDTO.getPessoaFisica());
		
		return usuarioRepository.save(usuario);
		
	}

	public void deleteUsuario(Long usr_id, UsuarioDTO usuarioDTO) {
		if (usuarioDTO.getUsr_id() == null || usr_id < 0) {
			throw new RuntimeException("Usuário com ID = [" + usr_id + "]" + HttpStatus.NOT_FOUND + " ");
		}

		usuarioRepository.deleteById(usuarioDTO.getUsr_id());
	}
}
