package com.cleanarchitecture.todos.api.data.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cleanarchitecture.todos.api.data.entities.TodoData;


public interface JpaTodoRepository extends CrudRepository<TodoData, Long>  {
	Optional<TodoData> findByName(String name);
}
