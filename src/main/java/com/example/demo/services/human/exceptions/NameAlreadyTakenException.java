package com.example.demo.services.human.exceptions;

public class NameAlreadyTakenException extends HumanException {
	private static final long serialVersionUID = -8144939486931579239L;

	public NameAlreadyTakenException() {
		super(MESSAGE);
	}
	
	private static final String MESSAGE = "This name is already taken!"; 

}
