package com.jonathascabeco.stswebservicesproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathascabeco.stswebservicesproject.domain.User;
import com.jonathascabeco.stswebservicesproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		//tem de conversar com o repositório
		return repo.findAll();		
	}	
}
