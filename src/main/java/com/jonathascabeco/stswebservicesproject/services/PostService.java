package com.jonathascabeco.stswebservicesproject.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathascabeco.stswebservicesproject.domain.Post;
import com.jonathascabeco.stswebservicesproject.repository.PostRepository;
import com.jonathascabeco.stswebservicesproject.services.exceptions.ObjectNotFoundExceptions;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//macete da data, ela é feita em milesegundos, tem considerar o dia inteiro;
		//por isso acresce um dia na data.
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	

}
