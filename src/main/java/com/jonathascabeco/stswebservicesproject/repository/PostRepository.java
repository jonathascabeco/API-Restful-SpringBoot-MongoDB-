package com.jonathascabeco.stswebservicesproject.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jonathascabeco.stswebservicesproject.domain.Post;

@Repository
//como implementar o repository usando springdata
public interface PostRepository extends MongoRepository<Post, String> {
	//tipo da classe de dominio que ele vai gerenciar, o tipo de id da classe;
	//aqui está sendo utilizado o repository do Mongo, no outro utilizamos o jpa;
	
		@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
		List<Post> searchTitle(String text);
	
		List<Post> findByTitleContainingIgnoreCase(String text);
		//Spring data monta consulta pré padronizada; nesse caso envia para o mongodb
		//uma solicitação JSON para consulta desejada, no caso, o que for escrito na 
		//string text; IgnoreCase para ignorar se é maiuscula ou minuscula
		
		@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
		// ou ele busca pelos campos pela string
		// e tem de estar entre a data min e max.
		List<Post> fullSearch(String text, Date minDate, Date maxDate);	
}
