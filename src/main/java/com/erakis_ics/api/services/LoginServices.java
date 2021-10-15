package com.erakis_ics.api.services;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erakis_ics.api.entity.Login;
import com.erakis_ics.api.repository.LoginRepository;

/*  
 * @author by: icarlos 
 */

@Service
public class LoginServices {

	@Autowired
	private LoginRepository loginRepository;

	public Login save(Login l) throws Exception {
		if (l == null) {
			throw new Exception("Usuário [" + l + "] não encontrado");
		} else {
			loginRepository.save(l);
		}
		return l;
	}

	public Login loginFindById(Long id) throws Exception {
		Optional<Login> findByID = loginRepository.findById(id);
		Login login = null;
		if (!findByID.isPresent()) {
			throw new Exception("Erro ao encontrar Usuário");
		} else {
			login = findByID.get();
		}
		return login;
	}

	public List<Login> loginFindAll() throws Exception {
		List<Login> listAll = loginRepository.findAll();
		if (listAll.isEmpty() || listAll.size() < 0) {
			throw new Exception("A lista está vázia");
		}
		return listAll;
	}

	public Login loginUpdate(Login l) throws Exception {
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

	public String hash() throws Exception {

		List<Login> list = loginRepository.findAll();
		Login login = new Login();
		String header = "Ivan.";
		String payload = "Carlos.";
		String asign = "Santos";
		String key = Base64.getEncoder().encodeToString((header + payload + asign).getBytes());

		if (list.isEmpty() || list.size() < 0) {
			throw new Exception("A lista está vázia");
		}

		login.setLogin("Ivan Santos");
		login.setLoginPassword(key);
		login.setUserName("@menor");
		list.add(login);

		byte[] decode = Base64.getDecoder().decode(key);
		String dc = new String(decode);

		return key + "[" + dc + "]";
	}

	public Date expiredSession() {
		Integer EXPIRED_SESSION_TIME = 600_000;
		return new Date(System.currentTimeMillis() + EXPIRED_SESSION_TIME);
	}
}
