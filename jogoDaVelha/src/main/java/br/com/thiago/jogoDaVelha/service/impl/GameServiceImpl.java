package br.com.thiago.jogoDaVelha.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.thiago.jogoDaVelha.DTO.Game;
import br.com.thiago.jogoDaVelha.exception.InvalidGameException;
import br.com.thiago.jogoDaVelha.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	public static final String PLAYER_X = "x";
	public static final String PLAYER_O = "o";

	@Value("${message.excpt.invalid.game}")
	private String excptMessage;
	
	@Value("${message.game.draw}")
	private String DRAW;

	@Override
	public String resolveGame(List<Integer> values) {
		int sumIndex = 0;
		int line = 0;

		// row
		for (int index = 0; index < 3; index++) {
			line = 0;
			sumIndex = index > 0 ? sumIndex += 1 : 0;
			line = values.get(sumIndex) + values.get(sumIndex += 1) + values.get(sumIndex += 1);
			if (line == 3) {
				return PLAYER_X;
			} else if (line == 6) {
				return PLAYER_O;
			}
		}

		// Column
		for (int index = 0; index < 3; index++) {
			line = 0;
			sumIndex = index > 0 ? sumIndex = index : 0;
			line = values.get(index) + values.get(sumIndex += 3) + values.get(sumIndex += 3);
			if (line == 3) {
				return PLAYER_X;
			} else if (line == 6) {
				return PLAYER_O;
			}
		}

		// DIAGONAL
		int d1 = values.get(0) + values.get(4) + values.get(8);
		int d2 = values.get(2) + values.get(4) + values.get(6);
		if (d1 == 3 || d2 == 3) {
			return PLAYER_X;
		} else if (d1 == 6 || d2 == 6) {
			return PLAYER_O;
		}

		return this.DRAW;
	}

	@Override
	public List<Integer> transformJsonInGame(Game game) throws Exception {
		StringBuilder sbGame = new StringBuilder();
		List<String> recivedGame = game.getJogo();
		recivedGame.stream().forEach(g -> sbGame.append(g));

		List<Integer> values = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			if (sbGame.charAt(i) == 'x') {
				values.add(1);
			} else if (sbGame.charAt(i) == 'o') {
				values.add(2);
			} else {
				throw new InvalidGameException(excptMessage);
			}
		}
		return values;
	}

}
