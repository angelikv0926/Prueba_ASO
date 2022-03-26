package com.api.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.api.entity.User;

public class UserTest {
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGetSetId() {
		final User ususario = new User();
		Long objectTest = 1L;
		
		ususario.setId(objectTest);
		assertEquals(objectTest, ususario.getId());
	}
	
	@Test
	public void testGetSetName() {
		final User ususario = new User();
		String objectTest = "pedro";
		
		ususario.setNombre(objectTest);
		assertEquals(objectTest, ususario.getNombre());
	}
	
	@Test
	public void testGetSetApellido() {
		final User ususario = new User();
		String objectTest = "Perez";
		
		ususario.setApellido(objectTest);
		assertEquals(objectTest, ususario.getApellido());
	}
	
	@Test
	public void testGetSetEmail() {
		final User ususario = new User();
		String objectTest = "pperez@gmail.com";
		
		ususario.setEmail(objectTest);
		assertEquals(objectTest, ususario.getEmail());
	}
}
