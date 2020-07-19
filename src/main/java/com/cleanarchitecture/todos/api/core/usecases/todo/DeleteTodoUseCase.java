package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

import javassist.NotFoundException;

@Service
public class DeleteTodoUseCase implements UseCase<GetTodoByIdUseCase.InputValues, DeleteTodoUseCase.OutputValues> {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public DeleteTodoUseCase.OutputValues execute(GetTodoByIdUseCase.InputValues inputValues) throws Exception {
		Optional<Todo> todo = todoRepository.findById(inputValues.getId());

		if (todo.isPresent()) {
			try {
				todoRepository.deleteById(inputValues.getId());
			} catch (Exception ex) {
				throw new Exception(ex.getMessage());
			}
		} else {
			throw new NotFoundException("Todo not found");
		}

		return null;
	}

	public static class OutputValues extends UseCaseOutputValues<Object> {

		@Override
		public void setOutPutObject(Object outputObject) {
			// TODO Auto-generated method stub

		}

	}
}
