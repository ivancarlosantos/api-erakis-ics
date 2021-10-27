package com.erakis_ics.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.entity.Usuario;
import com.erakis_ics.api.repository.UsuarioRepository;

/*  
 * @author by: icarlos 
 */

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository loginRepository;

	public Usuario save(Usuario l) throws Exception {
		if (l == null) {
			throw new Exception("Usuário [" + l + "] não encontrado");
		} else {
			loginRepository.save(l);
		}
		return l;
	}

	public Usuario loginFindById(Long id) throws Exception {
		Optional<Usuario> findByID = loginRepository.findById(id);
		Usuario login = null;
		if (!findByID.isPresent()) {
			throw new Exception("Erro ao encontrar Usuário");
		} else {
			login = findByID.get();
		}
		return login;
	}

	public List<Usuario> loginFindAll() throws Exception {
		List<Usuario> listAll = loginRepository.findAll();
		if (listAll.isEmpty() || listAll.size() < 0) {
			throw new Exception("A lista está vázia");
		}
		return listAll;
	}

	public Usuario loginUpdate(Usuario l) throws Exception {
		if (l == null) {
			throw new Exception("Usuário [" + l + "] não encontrado");
		}
		return loginRepository.saveAndFlush(l);
	}

	public void deleteById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Usuário não encontrado e/ou não existe");
		}
		loginRepository.deleteById(id);
	}

	public Date expiredSession() {
		Integer EXPIRED_SESSION_TIME = 600_000;
		return new Date(System.currentTimeMillis() + EXPIRED_SESSION_TIME);
	}
}
