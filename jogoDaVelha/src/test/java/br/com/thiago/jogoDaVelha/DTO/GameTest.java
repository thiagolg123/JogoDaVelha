package br.com.thiago.jogoDaVelha.DTO;

import static org.junit.Assert.assertNotNull;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Before
	public void init(){
		game = new Game(Stream.of("xxx","ooo","xxx").collect(Collectors.toList()));
	}
	
	@Test
	public void shouldGetJogo() throws Exception {
		assertNotNull(game.getJogo());
	}

	@Test
	public void shouldSetJogo() throws Exception {
		game = new Game(Stream.of("xxx","ooo","xxx").collect(Collectors.toList()));
		assertNotNull(game.getJogo());
	}
	

}
