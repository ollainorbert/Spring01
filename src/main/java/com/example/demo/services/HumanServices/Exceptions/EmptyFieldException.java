package com.example.demo.services.HumanServices.Exceptions;

public class EmptyFieldException extends HumanException {
	private static final long serialVersionUID = -8442018983129928059L;

	public EmptyFieldException() {
		super(MESSAGE);
	}
	
	private static final String MESSAGE = "Empty field";
}
