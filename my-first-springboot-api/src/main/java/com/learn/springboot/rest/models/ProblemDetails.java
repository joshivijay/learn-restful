package com.learn.springboot.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ProblemDetails {
	@JsonProperty
	private int status;
	@JsonProperty
	private String title;
	@JsonProperty
	private String detail;

	public ProblemDetails(int status, String title, String detail) {
		this.status = status;
		this.title = title;
		this.detail = detail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
