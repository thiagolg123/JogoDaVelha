package br.com.thiago.jogoDaVelha;

import java.util.ArrayList;
import java.util.List;

public class TestAlgorithm2 {

	public static void main(String[] args) throws Exception {

		String jogadorVencedor = null;
		String json = "xxoooxxox";

		long startTime = System.nanoTime();

		jogadorVencedor = resolveGame(transformJsonInGame(json.toLowerCase()));

		if (jogadorVencedor.equalsIgnoreCase("velha")) {
			long endTime = System.nanoTime();
			System.out.println("Velha :... duração da verificação: " + (endTime - startTime));
		} else {
			long endTime = System.nanoTime();
			System.out.println(
					"Temos um Ganhador " + jogadorVencedor + ":... duração da verificação: " + (endTime - startTime));
		}
	}

	/**
	 * Transform json in a list of int, for each value of x = 1, and o = 2;
	 * 
	 * @param json
	 * @return list of values
	 * @throws Exception
	 */
	private static List<Integer> transformJsonInGame(String json) throws Exception {
		List<Integer> values = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			if (json.charAt(i) == 'x') {
				values.add(1);
			} else if (json.charAt(i) == 'o') {
				values.add(2);
			} else {
				throw new Exception("Foi encontrado um caracter invalido no jogo");
			}
		}
		return values;
	}

	/**
	 * Method for testing rows, columns, diagonals, if any of these is the sum
	 * equivalent to 3 the winner X was found, if the sum is 6 we find the winner O
	 * 
	 * @param values
	 * @return
	 */
	static String resolveGame(List<Integer> values) {
		int sumIndex = 0;
		int line = 0;
		String playerX = "X";
		String playerO = "O";

		// LINHA
		for (int index = 0; index < 3; index++) {
			line = 0;
			sumIndex = index > 0 ? sumIndex += 1 : 0;
			line = values.get(sumIndex) + values.get(sumIndex += 1) + values.get(sumIndex += 1);
			if (line == 3) {
				return playerX;
			} else if (line == 6) {
				return playerO;
			}
		}

		// COLUNA
		for (int index = 0; index < 3; index++) {
			line = 0;
			sumIndex = index > 0 ? sumIndex = index : 0;
			line = values.get(index) + values.get(sumIndex += 3) + values.get(sumIndex += 3);
			if (line == 3) {
				return playerX;
			} else if (line == 6) {
				return playerO;
			}
		}

		// DIAGONAL
		int d1 = values.get(0) + values.get(4) + values.get(8);
		int d2 = values.get(2) + values.get(4) + values.get(6);
		if (d1 == 3 || d2 == 3) {
			return playerX;
		} else if (d1 == 6 || d2 == 6) {
			return playerO;
		}

		return "Velha";

	}
}
