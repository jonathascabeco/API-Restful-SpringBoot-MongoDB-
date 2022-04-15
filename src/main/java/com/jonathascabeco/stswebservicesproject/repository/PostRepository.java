package com.jonathascabeco.stswebservicesproject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jonathascabeco.stswebservicesproject.domain.Post;

@Repository
//como implementar o repository usando springdata
public interface PostRepository extends MongoRepository<Post, String> {
	//tipo da classe de dominio que ele vai gerenciar, o tipo de id da classe;
	//aqui está sendo utilizado o repository do Mongo, no outro utilizamos o jpa;
	
		List<Post> findByTitleContainingIgnoreCase(String text);
		//Spring data monta consulta pré padronizada; nesse caso envia para o mongodb
		//uma solicitação JSON para consulta desejada, no caso, o que for escrito na 
		//string text; IgnoreCase para ignorar se é maiuscula ou minuscula
}
