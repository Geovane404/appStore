package com.gtecnologia.store.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtecnologia.store.DTO.UserDTO;
import com.gtecnologia.store.entities.User;
import com.gtecnologia.store.repositories.UserRepository;
import com.gtecnologia.store.services.exceptions.DatabaseIntegrityException;
import com.gtecnologia.store.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
		Page<User> pageList = repository.findAll(pageRequest);
		return pageList.map(x -> new UserDTO(x));
	}

	@Transactional
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setPassword(dto.getPassword());

		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.findById(id).get();
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setPhone(dto.getPhone());
	
			entity = repository.save(entity);
			return new UserDTO(entity);
		}
		catch(NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DatabaseIntegrityException("Error: você não pode excluir um objeto que possui dependentes!");
		}

	}
}
