package com.erakis_ics.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.entity.Usuario;
import com.erakis_ics.api.repository.UsuarioRepository;
import com.erakis_ics.api.services.UsuarioServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*  
 * @author by: icarlos 
 */

@Api(value = "Erakis ICS API")
@CrossOrigin(origins = "*") // liberação para qualquer aplicação/domínio acessar
@RestController
//@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioServices usuarioServices;

	@PostMapping(path = "/usuario/save")
	@ApiOperation(value = "Salva um Usuário/Login")
	public Usuario save(@RequestBody Usuario login) throws Exception {
		return usuarioServices.save(login);
	}

	@GetMapping(path = "/usuario/listAll")
	@ApiOperation(value = "Retorna a lista de Usuários/Login")
	public List<Usuario> listLoginAll() throws Exception {
		return usuarioServices.loginFindAll();
	}

	@GetMapping(path = "/usuario/findByID/id/{id}")
	@ApiOperation(value = "Retorna Usuário/Login único por ID")
	public Optional<Usuario> findByID(@PathVariable(name = "id", required = true) Long id) {
		return usuarioRepository.findById(id);
	}

	@PutMapping(path = "/usuario/update")
	@ApiOperation(value = "Atualiza Usuário/Login")
	public Usuario update(@RequestBody Usuario login) throws Exception {
		return usuarioServices.save(login);
	}

	@DeleteMapping(path = "/usuario/delete/{id}")
	@ApiOperation(value = "Deleta um Usuário/Login por ID")
	public void delete(@PathVariable(name = "id", required = true) Long id) throws Exception {
		usuarioServices.deleteById(id);
	}
}

