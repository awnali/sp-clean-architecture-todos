package com.cleanarchitecture.todos.api.data.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.cleanarchitecture.todos.api.common.MapModel;
import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.domain.enums.TodoStatus;




@Entity(name = "todos")
public class TodoData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private TodoStatus status;

	public TodoData() {
	}

	public TodoData(String name, TodoStatus status, Long Id) {
		this.id = Id;
		this.name = name;
		this.status = status;
	}

	
	public String getName() {
		return name;
	}

	public TodoStatus getStatus() {
		return status;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(TodoStatus status) {
		this.status = status;
	}

	public static TodoData from(Todo todo) {	
		return MapModel.map(todo, TodoData.class);
	}

	public static Todo fromThis(TodoData todoData) {
		return MapModel.map(todoData, Todo.class);
	}
}
