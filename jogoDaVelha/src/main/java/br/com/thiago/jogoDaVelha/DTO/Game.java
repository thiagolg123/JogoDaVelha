package br.com.thiago.jogoDaVelha.DTO;

import java.util.List;

public class Game {

	private List<String> jogo;

	public Game(List<String> collect) {
		setJogo(collect);
	}

	public List<String> getJogo() {
		return jogo;
	}

	public void setJogo(List<String> jogo) {
		this.jogo = jogo;
	}
}
