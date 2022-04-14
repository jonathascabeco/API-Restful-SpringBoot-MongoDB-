package com.jonathascabeco.stswebservicesproject.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jonathascabeco.stswebservicesproject.domain.User;
import com.jonathascabeco.stswebservicesproject.dto.UserDTO;
import com.jonathascabeco.stswebservicesproject.services.UserService;

@RestController // para setar a classe como recurso rest;
@RequestMapping(value = "/users") // caminho do endpoint;
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	// @GetMapping a mesma coisas que o de cima, estabelece o método de acesso a
	// função em questão;
	public ResponseEntity<List<UserDTO>> findAll() {
		// responseentity = retornar um obj sofisticado encapsula uma estrutura
		// necessaria
		// para retornar uma resposta http(possíveis cabeçalhos, erros etc)
		List<User> list = service.findAll();
		// List é interface nao pode instanciar, tem de colocar uma implementação da
		// interface para instanciar
		// no caso, o ArrayList;
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		// retornando a lista no corpo da resposta;
	}
}
