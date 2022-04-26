package com.learn.springboot.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.springboot.rest.models.CreateUserRequest;
import com.learn.springboot.rest.models.CreateUserResponse;
import com.learn.springboot.rest.models.GetUserResponse;
import com.learn.springboot.rest.models.ProblemDetailsException;
import com.learn.springboot.rest.models.User;

@Service
public class UserService {

	private static final List<User> USERS = new ArrayList<>();

	public UserService() {
		User userA = new User();
		userA.setId(1);
		userA.setName("VJ");
		userA.setAge(31);

		User userB = new User();
		userB.setId(2);
		userB.setName("KJ");
		userB.setAge(31);

		User userC = new User();
		userC.setId(3);
		userC.setName("KM");
		userC.setAge(1);

		USERS.add(userA);
		USERS.add(userB);
		USERS.add(userC);
	}

	public GetUserResponse getUser(int id) throws Exception {
		if (id > USERS.size()) {
			throw new ProblemDetailsException(404, "Not Found", "User id not found");
		}
		GetUserResponse response = new GetUserResponse();
		List<User> users = new ArrayList<>();
		users.add(USERS.get(id - 1));
		response.setUsers(users);
		return response;
	}

	public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
		int currentId = USERS.size() + 1;

		User user = new User();
		user.setId(currentId);
		user.setName(createUserRequest.getName());
		user.setAge(createUserRequest.getAge());
		USERS.add(user);

		CreateUserResponse response = new CreateUserResponse();
		response.setId(currentId);
		response.setStatus("Success");
		return response;

	}

	public GetUserResponse getAllUsers() {
		GetUserResponse response = new GetUserResponse();
		response.setUsers(USERS);
		return response;
	}

}
