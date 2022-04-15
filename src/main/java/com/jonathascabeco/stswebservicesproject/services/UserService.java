package com.jonathascabeco.stswebservicesproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathascabeco.stswebservicesproject.domain.User;
import com.jonathascabeco.stswebservicesproject.dto.UserDTO;
import com.jonathascabeco.stswebservicesproject.repository.UserRepository;
import com.jonathascabeco.stswebservicesproject.services.exceptions.ObjectNotFoundExceptions;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		// tem de conversar com o repositório
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());// obj original do db Mongo;
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());		
	}

	// nao foi feito no UserDto, pois aqui ja tem uma instanciação pro bd, caso
	// precise de alguma
	// manutenção;
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
