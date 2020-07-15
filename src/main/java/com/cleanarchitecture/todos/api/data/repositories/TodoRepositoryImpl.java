package com.cleanarchitecture.todos.api.data.repositories;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.todo.TodoRepository;
import com.cleanarchitecture.todos.api.data.entities.TodoData;

@Service
public class TodoRepositoryImpl implements TodoRepository {

	private JpaTodoRepository jpaTodoRepository;

	public TodoRepositoryImpl(JpaTodoRepository jpaTodoRepository) {
		this.jpaTodoRepository = jpaTodoRepository;
	}

	@Override
	public Optional<Todo> findByName(String name) {
		Optional<Todo> todo = jpaTodoRepository.findByName(name).map(TodoData::fromThis);
		
		return todo;
	}

	@Override
	public Todo persist(Todo todo) {
		TodoData newly = TodoData.from(todo);
		TodoData createdTodo = jpaTodoRepository.save(newly);
		return TodoData.fromThis(createdTodo);
	}

	@Override
	public Optional<Todo> findById(Long id) {
		return jpaTodoRepository.findById(id).map(TodoData::fromThis);
	}

	@Override
	public void deleteById(Long id) {
		jpaTodoRepository.deleteById(id);
	}
}
