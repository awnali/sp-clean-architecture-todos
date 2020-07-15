package com.cleanarchitecture.todos.api.core.domain;

public class NotFoundException extends DomainException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8855393676723375734L;

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String messageFormat, Object... args) {
		super(String.format(messageFormat, args));
	}
}
