package com.learn.springboot.rest.models;

public class ProblemDetailsException extends Exception {
	private static final long serialVersionUID = 7987184766285351081L;

	private ProblemDetails problemDetails;

	public ProblemDetailsException(int status, String title, String detail) {
		problemDetails = new ProblemDetails(status, title, detail);
	}

	public ProblemDetails getProblemDetails() {
		return problemDetails;
	}

}
