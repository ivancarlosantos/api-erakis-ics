package com.erakis_ics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erakis_ics.api.dtos.UsuarioDTO;
import com.erakis_ics.api.entity.Usuario;
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
	private UsuarioServices usuarioServices;
	
	@PostMapping(path = "/usuario/save")
	@ApiOperation(value = "Cria/Salva um Usuário")
	public ResponseEntity<UsuarioDTO> save(@RequestBody Usuario usr){
		Usuario usuario = usuarioServices.saveUsuario(usr);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return ResponseEntity.ok().body(usuarioDTO);
	}

	@GetMapping(path = "/usuario/listUsuarioTodos")
	@ApiOperation(value = "Retorna a lista de Usuários")
	public ResponseEntity<List<UsuarioDTO>> listUsuarioAll() {
		List<UsuarioDTO> usuarioDTO = usuarioServices.usuarioFindAll();
		return ResponseEntity.ok().body(usuarioDTO);
	}
	
	@GetMapping(path = "/usuario/findUsuarioByID/{usr_id}")
	@ApiOperation(value = "Retorna Usuário pelo identificador ID")
	public ResponseEntity<UsuarioDTO> findUsuarioByID(@PathVariable(name = "usr_id", required = true) Long usr_id) {
		Usuario usuario = usuarioServices.findUsuarioByID(usr_id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return ResponseEntity.ok().body(usuarioDTO);
	}

	@PutMapping(path = "/usuario/update/{usr_id}")
	@ApiOperation(value = "Atualiza os registros de um Usuário")
	public ResponseEntity<Usuario> update(@PathVariable()Long usr_id, @RequestBody Usuario usuarioDTO){
		Usuario usuario = usuarioServices.updateUsuario(usr_id, usuarioDTO);
		return ResponseEntity.ok().body(usuario);
	}

	@DeleteMapping(path = "/usuario/delete/{usr_id}")
	@ApiOperation(value = "Deleta um Usuário por ID")
	public void delete(@PathVariable(name = "id", required = true) Long usr_id, UsuarioDTO usuarioDTO) {
		usuarioServices.deleteUsuario(usr_id, usuarioDTO);
		ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}
}

