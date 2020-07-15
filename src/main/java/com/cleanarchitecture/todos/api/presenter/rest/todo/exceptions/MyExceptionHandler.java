package com.cleanarchitecture.todos.api.presenter.rest.todo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cleanarchitecture.todos.api.common.ReturnApiResponse;
import com.cleanarchitecture.todos.api.presenter.rest.responses.ApiResponse;

public class MyExceptionHandler extends RuntimeException {
	
	private static final long serialVersionUID = -6129292835181151784L;
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponse<Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
		return ReturnApiResponse.error(ex.getMessage());
	}
}
