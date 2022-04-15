package com.jonathascabeco.stswebservicesproject.services;

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

}
