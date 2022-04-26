package com.learn.springboot.rest.services;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learn.springboot.rest.models.GetUserResponse;
import com.learn.springboot.rest.models.ProblemDetailsException;

public class UserServiceTest {
	private UserService userService;

	@BeforeEach
	public void before() {
		userService = new UserService();
	}

	@Test
	public void testGetUser() throws Exception {
		GetUserResponse getUserResponse = userService.getUser(1);
		assertNotNull(getUserResponse);
		assertNotNull(getUserResponse.getUsers());
		assertEquals(1, getUserResponse.getUsers().size());
		assertNotNull(getUserResponse.getUsers().get(0));
		assertEquals(1, getUserResponse.getUsers().get(0).getId());
	}

	@Test
	public void testGetUserThrowsNotFound() {
		ProblemDetailsException problemDetailsException = assertThrows(ProblemDetailsException.class,
				() -> userService.getUser(10));
		assertNotNull(problemDetailsException);
		assertNotNull(problemDetailsException.getProblemDetails());
		assertEquals(404, problemDetailsException.getProblemDetails().getStatus());
		assertEquals("Not Found", problemDetailsException.getProblemDetails().getTitle());
		assertEquals("User id not found", problemDetailsException.getProblemDetails().getDetail());
	}

}
