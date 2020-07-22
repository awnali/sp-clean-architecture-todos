package com.cleanarchitecture.todos.api.presenter.rest.requests;

import com.cleanarchitecture.todos.api.core.domain.enums.TodoStatus;

public class EditTodoRequest {

	public String name;

	public TodoStatus status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TodoStatus getStatus() {
		return status;
	}

	public void setStatus(TodoStatus status) {
		this.status = status;
	}

}
