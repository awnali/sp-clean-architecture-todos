package com.cleanarchitecture.todos.api.presenter.rest.todo;

import org.springframework.http.ResponseEntity;
import com.google.common.reflect.TypeToken;

import com.cleanarchitecture.todos.api.common.MapModel;
import com.cleanarchitecture.todos.api.common.ReturnApiResponse;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;
import com.cleanarchitecture.todos.api.presenter.rest.responses.ApiResponse;

public class SuccessResponseMapper<R, I extends UseCaseOutputValues<?>> {

	public ResponseEntity<ApiResponse<R>> map(
			I useCaseOuputValues) {
		
		R res = null;
		
		if(useCaseOuputValues != null) {
			TypeToken<R> typeToken = new TypeToken<R>(getClass()) {
				private static final long serialVersionUID = 3704688974743226860L; };
			res = MapModel.map(useCaseOuputValues.outputObject, typeToken.getType());
		}
		
		return ReturnApiResponse.success(res);
	}
}
