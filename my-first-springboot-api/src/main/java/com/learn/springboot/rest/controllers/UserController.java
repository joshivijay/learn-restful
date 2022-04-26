package com.learn.springboot.rest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.rest.models.CreateUserRequest;
import com.learn.springboot.rest.models.CreateUserResponse;
import com.learn.springboot.rest.models.GetUserResponse;
import com.learn.springboot.rest.models.ProblemDetails;
import com.learn.springboot.rest.models.ProblemDetailsException;
import com.learn.springboot.rest.models.User;
import com.learn.springboot.rest.services.UserRepository;
import com.learn.springboot.rest.services.UserService;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Value("${myjdbc.property}")
	private String prop;

	@GetMapping(path = "/greet")
	@ResponseStatus(code = HttpStatus.OK)
	public String greetUser() {
		return "Hello world!";
	}

	@GetMapping(path = "/greet/{user}")
	@ResponseStatus(code = HttpStatus.OK)
	public String greetUser(@PathVariable String user) {
		return "Hello " + user + "!";
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public User getUser(@PathVariable int id) throws Exception {
		Optional<User> user = userRepository.findById(id);

		return user.orElseThrow(() -> new ProblemDetailsException(404, "Not Found", "User id not found"));

		// return userService.getUser(id);
	}

	@GetMapping(path = "/name", params = "name", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public GetUserResponse getUser(@RequestParam String name) throws Exception {
		GetUserResponse response = new GetUserResponse();
		response.setUsers(new ArrayList<User>());
		Iterable<User> users = userRepository.findByName(name);
		users.forEach(a -> response.getUsers().add(a));
		return response;

		// return userService.getUser(id);
	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public GetUserResponse getAllUsers() {
		GetUserResponse response = new GetUserResponse();
		response.setUsers(new ArrayList<User>());
		Iterable<User> users = userRepository.findAll();
		users.forEach(a -> response.getUsers().add(a));
		return response;
		// return userService.getAllUsers();
	}

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public CreateUserResponse createUser(@RequestBody CreateUserRequest userRequest) {
		System.out.println("*** prop is " + prop);
		User user = new User();
		user.setAge(userRequest.getAge());
		user.setName(userRequest.getName());
		User savedUser = userRepository.saveAndFlush(user);

		CreateUserResponse response = new CreateUserResponse();
		response.setId(savedUser.getId());
		response.setStatus("Success");
		return response;
		// return userService.createUser(userRequest);
	}

	@ExceptionHandler(ProblemDetailsException.class)
	public ResponseEntity<ProblemDetails> handleProblemDetailsException(
			ProblemDetailsException problemDetailsException) {
		return new ResponseEntity<ProblemDetails>(problemDetailsException.getProblemDetails(),
				HttpStatus.valueOf(problemDetailsException.getProblemDetails().getStatus()));
	}
}
