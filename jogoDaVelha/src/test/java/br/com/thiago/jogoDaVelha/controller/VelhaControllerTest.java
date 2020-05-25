package br.com.thiago.jogoDaVelha.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.thiago.jogoDaVelha.DTO.Game;
import br.com.thiago.jogoDaVelha.enums.MockTypeGames;

@SpringBootTest
public class VelhaControllerTest {

	@Autowired
	private VelhaController controller;

	@Test
	public void shouldVerifyGameAndRespondeHttpOk() throws Exception {
		ResponseEntity<String> responseToX = controller.verificaJogo(mockGame(MockTypeGames.GANHADOR_X));
		ResponseEntity<String> responseToY = controller.verificaJogo(mockGame(MockTypeGames.GANHADOR_O));

		assertThat(responseToX.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseToY.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldVerifyGameAndRespondeDraw() throws Exception {
		ResponseEntity<String> response = controller.verificaJogo(mockGame(MockTypeGames.EMPATE));

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void shouldVerifyReturnInvalidGameException() throws Exception {
		ResponseEntity<String> response = controller.verificaJogo(mockGame(MockTypeGames.JOGADOR_INVALIDO));
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

	private Game mockGame(MockTypeGames type) {
		if (type.equals(MockTypeGames.GANHADOR_X)) {
			return new Game(Stream.of("xox", "xxo", "oox").collect(Collectors.toList()));
		}

		if (type.equals(MockTypeGames.GANHADOR_O)) {
			return new Game(Stream.of("ooo", "xxo", "oox").collect(Collectors.toList()));
		}

		if (type.equals(MockTypeGames.JOGADOR_INVALIDO)) {
			return new Game(Stream.of("oJo", "xxo", "oox").collect(Collectors.toList()));
		}

		return new Game(Stream.of("oxo", "xxo", "oox").collect(Collectors.toList()));
	}

}
