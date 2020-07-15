package com.cleanarchitecture.todos.api.presenter.rest.responses;

public final class ApiResponse<B> {
	
	private final String message;
	private final Boolean success;
	private final B body;

	public ApiResponse(String message, Boolean success, B body) {
		this.message = message;
		this.success = success;
		this.body = body;
	}

	public B getBody() {
		return body;
	}

	public String getMessage() {
		return message;
	}

	public Boolean getSuccess() {
		return success;
	}
	
}
