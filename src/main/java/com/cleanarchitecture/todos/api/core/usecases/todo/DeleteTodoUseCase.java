package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.DeleteUseCaseOutputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetTodoByIdUseCaseInputValues;

import javassist.NotFoundException;


@Service
public class DeleteTodoUseCase implements UseCase<GetTodoByIdUseCaseInputValues, DeleteUseCaseOutputValues>{

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public DeleteUseCaseOutputValues execute(GetTodoByIdUseCaseInputValues inputValues) throws Exception {
		Optional<Todo> todo =  todoRepository.findById(inputValues.getId());
		
		if(todo.isPresent()) {
			try {
				todoRepository.deleteById(inputValues.getId());
			}
			catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}
		else {
			throw new NotFoundException("Todo not found");
		}
		
		return null;
	}

}
