package com.cleanarchitecture.todos.api.common;

import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;

public final class MapModel {

	public static <S, D> D map(S source, Class<D> destinationClass) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(source, destinationClass);
	}
	public static <S, D> D map(S source, Type destinationClass) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(source, destinationClass);
	}
}
