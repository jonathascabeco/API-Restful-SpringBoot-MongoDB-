package com.jonathascabeco.stswebservicesproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jonathascabeco.stswebservicesproject.domain.Post;

@Repository
//como implementar o repository usando springdata
public interface PostRepository extends MongoRepository<Post, String> {
	//tipo da classe de dominio que ele vai gerenciar, o tipo de id da classe;
	//aqui está sendo utilizado o repository do Mongo, no outro utilizamos o jpa;
	
		
}
