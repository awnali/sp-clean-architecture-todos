package com.cleanarchitecture.todos.api.core.domain;


import com.cleanarchitecture.todos.api.enums.TodoStatus;

public class Todo {

	private Long id;
	private String name;
	private TodoStatus status = TodoStatus.PENDING;

	public Long getId() {
		return id;
	}

	public Todo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Todo setName(String name) {

		this.name = name;
		return this;
	}

	public TodoStatus getStatus() {
		return status;
	}

	public Todo setStatus(TodoStatus status) {
		this.status = status;
		return this;
	}

	public static Todo makeTodo(String name) throws Exception {
		
		if(name == null || name.isEmpty()) {
			throw new Exception("name can't be empty");
		}
		return new Todo().setId(Long.MIN_VALUE).setName(name);
	}

}
