package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.User;
import com.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional
	public List<User> getAll() {
        return userRepository.findAll();
    }
	
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public User updateUser(User newUser){
		Optional<User> userFind = userRepository.findById(newUser.getId());
		
		if(!userFind.isEmpty()) {
			return userFind
	                .map(user -> {
	                	user.setNombre(newUser.getNombre()!= null ? newUser.getNombre() : userFind.get().getNombre());
	                	user.setApellido(newUser.getApellido()!= null ? newUser.getApellido() : userFind.get().getApellido());
	                    user.setEmail(newUser.getEmail()!= null ? newUser.getEmail() : userFind.get().getEmail());
	                    user.setSn_hab(newUser.getSn_hab()!= null ? newUser.getSn_hab() : userFind.get().getSn_hab());
	                    return userRepository.save(user);
	                }).get();
		}
		return null;
    }
	
	@Transactional
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	/*@Transactional(readOnly = true)
	public User findByNameWithQuery(String name) {
		return userRepository.findByNameWithQuery(name);
	}*/
}