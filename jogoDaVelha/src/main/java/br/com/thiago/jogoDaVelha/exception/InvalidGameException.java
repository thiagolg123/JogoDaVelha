package br.com.thiago.jogoDaVelha.exception;

public class InvalidGameException extends Exception {

	private static final long serialVersionUID = 2314102857903628061L;

	public InvalidGameException(String message) {
		super(message);
	}
}
