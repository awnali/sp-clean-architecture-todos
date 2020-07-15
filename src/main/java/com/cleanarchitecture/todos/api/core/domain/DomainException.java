package com.cleanarchitecture.todos.api.core.domain;

public abstract class DomainException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6207165960699121174L;

	public DomainException(String message) {
        super(message);
    }
}
