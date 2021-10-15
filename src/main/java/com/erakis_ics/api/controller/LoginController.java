package com.erakis_ics.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.entity.Login;
import com.erakis_ics.api.repository.LoginRepository;
import com.erakis_ics.api.services.LoginServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*  
 * @author by: icarlos 
 */

@Api(value = "Erakis ICS API")
@CrossOrigin(origins = "*") // liberação para qualquer aplicação/domínio acessar
@RestController
//@RequestMapping(value = "/api")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private LoginServices loginServices;

	@GetMapping(path = "/login/status")
	@ApiOperation(value = "Retorna Status de Conexão OK, se ativo")
	public String status() {
		return "Status: [" + HttpStatus.OK + "] CONNECTION EXPIRED " + loginServices.expiredSession();
	}

	@PostMapping(path = "/login/save")
	@ApiOperation(value = "Salva um Usuário/Login")
	public Login save(@RequestBody Login login) throws Exception {
		return loginServices.save(login);
	}

	@GetMapping(path = "/login/listAll")
	@ApiOperation(value = "Retorna a lista de Usuários/Login")
	public List<Login> listLoginAll() throws Exception {
		return loginServices.loginFindAll();
	}

	@GetMapping(path = "/login/findByID/id/{id}")
	@ApiOperation(value = "Retorna Usuário/Login único por ID")
	public Optional<Login> findByID(@PathVariable(name = "id", required = true) Long id) {
		return loginRepository.findById(id);
	}

	@PutMapping(path = "/login/update")
	@ApiOperation(value = "Atualiza Usuário/Login")
	public Login update(@RequestBody Login login) throws Exception {
		return loginServices.save(login);
	}

	@DeleteMapping(path = "/login/delete/{id}")
	@ApiOperation(value = "Deleta um Usuário/Login por ID")
	public void delete(@PathVariable(name = "id", required = true) Long id) throws Exception {
		loginServices.deleteById(id);
	}

	@GetMapping(path = "/login/listHash")
	@ApiOperation(value = "Lista os HashCrypt gerados")
	public String listHash() throws Exception {
		return loginServices.hash();
	}

}
