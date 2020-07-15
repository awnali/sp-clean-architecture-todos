package com.cleanarchitecture.todos.api.core.usecases;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.common.ReturnApiResponse;
import com.cleanarchitecture.todos.api.presenter.rest.responses.ApiResponse;
import com.cleanarchitecture.todos.api.presenter.rest.todo.SuccessResponseMapper;

@Service
public class UseCaseExecutor<R> {

	public <I extends UseCaseInputValues, O extends UseCaseOutputValues<?>> ResponseEntity<ApiResponse<R>> execute(
			UseCase<I, O> useCase, I input) {
		try {
			O output = useCase.execute(input);
			return new SuccessResponseMapper<R>().getResponse(output);
		} catch (Exception ex) {
			return ReturnApiResponse.error(ex.getMessage());
		}

	}
}
