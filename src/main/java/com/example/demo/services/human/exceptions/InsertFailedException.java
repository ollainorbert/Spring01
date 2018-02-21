package com.example.demo.services.human.exceptions;

public class InsertFailedException extends HumanException {
	private static final long serialVersionUID = 5290682671926197798L;

	public InsertFailedException() {
		super(MESSAGE);
	}
	
	private static final String MESSAGE = "Insert failed! Try again later!";

}
