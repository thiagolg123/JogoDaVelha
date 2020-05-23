package br.com.thiago.jogoDaVelha;

import java.util.ArrayList;
import java.util.List;

public class TestAlgorithm1NotUsed {
	
	public static void main(String[] args) {

		String jogadorVencedor = null;
		List<String> jogo = new ArrayList<>(9);

		String json = "xxoooxxox"; // transformar o json nisso
		long startTime = System.nanoTime();
		for (int i = 0; i < 9; i++) {
			jogo.add(Character.toString(json.charAt(i)));
		}

		jogadorVencedor = resolveGanhador(jogo);

		if (jogadorVencedor.equalsIgnoreCase("velha")) {
			long endTime = System.nanoTime();
			System.out.println("Velha :... duração da verificação: " + (endTime - startTime));
		} else {
			long endTime = System.nanoTime();
			System.out.println(
					"Temos um Ganhador " + jogadorVencedor + ":... duração da verificação: " + (endTime - startTime));
		}
	}

	static String resolveGanhador(List<String> jogo) {
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			// Linhas
			case 0:
				line = jogo.get(0) + jogo.get(1) + jogo.get(2);
				break;
			case 1:
				line = jogo.get(3) + jogo.get(4) + jogo.get(5);
				break;
			case 2:
				line = jogo.get(6) + jogo.get(7) + jogo.get(8);
				break;

			// colunas
			case 3:
				line = jogo.get(0) + jogo.get(3) + jogo.get(6);
				break;
			case 4:
				line = jogo.get(1) + jogo.get(4) + jogo.get(7);
				break;
			case 5:
				line = jogo.get(2) + jogo.get(5) + jogo.get(8);
				break;

			// diagonais
			case 6:
				line = jogo.get(0) + jogo.get(4) + jogo.get(8);
				break;
			case 7:
				line = jogo.get(2) + jogo.get(4) + jogo.get(6);
				break;
			}

			if (line.equalsIgnoreCase("XXX")) {
				return "X";
			} else if (line.equalsIgnoreCase("OOO")) {
				return "O";
			}
		}
		return "velha";
	}
}
