package com.cleanarchitecture.todos.api.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cleanarchitecture.todos.api.presenter.rest.responses.ApiResponse;

public final class ReturnApiResponse {

	public static <R> ResponseEntity<ApiResponse<R>> success(R body) {
		ApiResponse<R> response = new ApiResponse<R>("Success", true, body);
		return new ResponseEntity<ApiResponse<R>>(response, HttpStatus.OK);
	}

	public static <R> ResponseEntity<ApiResponse<R>> error(String reason) {
		ApiResponse<R> response = new ApiResponse<R>(reason, false, null);
		return new ResponseEntity<ApiResponse<R>>(response, HttpStatus.BAD_REQUEST);
	}
}
