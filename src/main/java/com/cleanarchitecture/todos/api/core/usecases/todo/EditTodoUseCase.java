package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.EditUseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.EditUseCaseOutputValues;

@Service
public class EditTodoUseCase implements UseCase<EditUseCaseInputValues, EditUseCaseOutputValues<?>> {

	@Override
	public EditUseCaseOutputValues<?> execute(EditUseCaseInputValues inputValues) {
		System.out.println(inputValues.todo.getName());
		return null;
	}

}
