package com.learn.springboot.rest.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CreateUserResponse {
	private int id;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
