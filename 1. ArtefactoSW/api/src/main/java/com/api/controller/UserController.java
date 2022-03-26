package com.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.User;
import com.api.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
    List<User> get(){
        return userService.getAll();
    }
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}
	
	@GetMapping(path = "/find/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long UserId) {		
		Optional<User> oUser = userService.findById(UserId);
		if(oUser.isPresent()) {
			return ResponseEntity.ok(oUser);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/update")
    ResponseEntity<User> updateUser(@RequestBody User newUser){
        User user = userService.updateUser(newUser);
        if(user != null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/delete/{id}")
    ResponseEntity deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
	
	/*@GetMapping(path = "/nombre/{name}")
	public String findByNameWithQuery(@PathVariable("name") String name) {		
		User user = userService.findByNameWithQuery(name);
		if(user == null) {
			return "No se encontró ningún usuario con el nombre " + name;
		}
		return "El usuario " + name + " tiene el ID " + user.getId();
	}*/
}
