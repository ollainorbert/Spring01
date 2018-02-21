package com.example.demo.services.human.exceptions;

public abstract class HumanException extends Exception {
	private static final long serialVersionUID = -7356954973366695048L;

	public HumanException(String msg) {
		super(msg);
	}
}
