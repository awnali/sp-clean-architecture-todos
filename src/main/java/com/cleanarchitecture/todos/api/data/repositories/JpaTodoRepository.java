package com.cleanarchitecture.todos.api.data.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleanarchitecture.todos.api.data.entities.TodoData;


public interface JpaTodoRepository extends JpaRepository<TodoData, Long>  {
	Optional<TodoData> findByName(String name);
}
