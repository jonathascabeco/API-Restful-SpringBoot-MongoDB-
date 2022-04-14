package com.jonathascabeco.stswebservicesproject.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jonathascabeco.stswebservicesproject.domain.User;

@Repository
//como implementar o repository usando springdata
public interface UserRepository extends MongoRepository<User, String> {
	//tipo da classe de dominio que ele vai gerenciar, o tipo de id da classe;
	//aqui está sendo utilizado o repository do Mongo, no outro utilizamos o jpa;
	
		
}
