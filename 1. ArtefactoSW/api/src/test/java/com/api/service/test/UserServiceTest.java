package com.api.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.api.entity.User;
import com.api.repository.UserRepository;
import com.api.service.UserService;

public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testFindAllIterable() {
		User user = new User();
		user.setNombre("pedro");
		
		ArrayList<User> listUser = new ArrayList<>();
		listUser.add(user);
		
		when(userRepository.findAll()).thenReturn(listUser);
		
		Iterable<User> rspUser = userService.findAll();
		
		assertEquals(rspUser, listUser);
	}
	
	@Test
	public void testGetAll() {
		User user = new User();
		user.setNombre("pedro");
		
		List<User> listUser = new ArrayList<>();
		listUser.add(user);
		
		when(userRepository.findAll()).thenReturn(listUser);
		
		List<User> rspUser = userService.getAll();
		
		assertEquals(rspUser, listUser);
	}
	
	@Test
	public void testFindById() {
		User user = new User();
		user.setNombre("pedro");
		Optional<User> userOpt = Optional.of(user);
		
		when(userRepository.findById(anyLong())).thenReturn(userOpt);
		
		Optional<User> rspUser = userService.findById(1L);
		
		assertEquals(rspUser.get().getNombre(), userOpt.get().getNombre());
	}
	
	@Test
	public void testSaveUser() {
		User user = new User();
		user.setId(1L);
		user.setNombre("pedro");
		user.setApellido("perez");
		user.setEmail("pperez@gmail.com");
		user.setSn_hab(true);
		
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		User rspUser = userService.saveUser(new User());
		
		assertEquals(rspUser, user);
	}
	
	@Test
	public void testUpdateUserOptionalEmpty() {
		Optional<User> userOpt = Optional.empty();
		
		when(userRepository.findById(anyLong())).thenReturn(userOpt);
		
		User rspUser = userService.updateUser(new User());
		
		assertNull(rspUser);
	}
	
	@Test
	public void testUpdateUserOptionalWithData() {
		User user = new User();
		user.setId(1L);
		user.setNombre("pedro");
		user.setApellido("perez");
		user.setEmail("pperez@gmail.com");
		user.setSn_hab(true);
		Optional<User> userOpt = Optional.of(user);
		
		when(userRepository.findById(anyLong())).thenReturn(userOpt);
		
		User userTest = new User();
		userTest.setId(2L);
		userTest.setNombre("juan");
		userTest.setApellido("lopez");
		userTest.setEmail("jlopez@gmail.com");
		userTest.setSn_hab(false);
		
		when(userRepository.save(any(User.class))).thenReturn(userTest);
		
		User rspUser = userService.updateUser(userTest);
		
		assertEquals(rspUser.getNombre(), userTest.getNombre());
	}
	
	@Test
	public void testUpdateUserOptionalWithOutData() {
		User user = new User();
		user.setId(1L);
		user.setNombre("pedro");
		user.setApellido("perez");
		user.setEmail("pperez@gmail.com");
		user.setSn_hab(true);
		Optional<User> userOpt = Optional.of(user);
		
		when(userRepository.findById(anyLong())).thenReturn(userOpt);
		
		User userTest = new User();
		userTest.setId(1L);
		userTest.setNombre(null);
		userTest.setApellido(null);
		userTest.setEmail(null);
		userTest.setSn_hab(null);
		
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		User rspUser = userService.updateUser(userTest);
		
		assertEquals(rspUser.getNombre(), user.getNombre());
	}
	
	@Test
	public void testDeleteUser() {
		User user = new User();
		user.setId(1L);
		
		doNothing().when(userRepository).deleteById(anyLong());
		userService.deleteUser(anyLong());
	}
}