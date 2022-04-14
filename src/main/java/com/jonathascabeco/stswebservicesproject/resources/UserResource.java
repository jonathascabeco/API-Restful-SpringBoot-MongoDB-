package com.jonathascabeco.stswebservicesproject.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jonathascabeco.stswebservicesproject.domain.User;
import com.jonathascabeco.stswebservicesproject.services.UserService;

@RestController // para setar a classe como recurso rest;
@RequestMapping(value = "/users") // caminho do endpoint;
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	// @GetMapping a mesma coisas que o de cima, estabelece o método de acesso a
	// função em questão;
	public ResponseEntity<List<User>> findAll() {
		// responseentity = retornar um obj sofisticado encapsula uma estrutura
		// necessaria
		// para retornar uma resposta http(possíveis cabeçalhos, erros etc)
		List<User> list = service.findAll();
		// List é interface nao pode instanciar, tem de colocar uma implementação da
		// interface para instanciar
		// no caso, o ArrayList;
		return ResponseEntity.ok().body(list);
		// retornando a lista no corpo da resposta;
	}
}
