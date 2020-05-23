package br.com.thiago.jogoDaVelha.service;

import java.util.List;

import br.com.thiago.jogoDaVelha.DTO.Game;

public interface GameService {

	/**
	 * Method for testing rows, columns, diagonals, if any of these is the sum
	 * equivalent to 3 the winner X was found, if the sum is 6 we find the winner O
	 * 
	 * @param List of values ​​of x and o already transformed
	 * @return result of the game
	 */
	public String resolveGame(List<Integer> values);

	/**
	 * Transform json in a list of int, for each value of x = 1, and o = 2;
	 * 
	 * @param game json
	 * @return list of values
	 * @throws Exception
	 */
	public List<Integer> transformJsonInGame(Game game) throws Exception;
}
