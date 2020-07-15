package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.List;
import java.util.Optional;

import com.cleanarchitecture.todos.api.core.domain.Todo;

public interface TodoRepository {
	List<Todo> findAll(int pageNumber, int size);

	Optional<Todo> findByName(String name);

	Optional<Todo> findById(Long Id);

	Todo persist(Todo todo);

	void deleteById(Long todoId);
}
