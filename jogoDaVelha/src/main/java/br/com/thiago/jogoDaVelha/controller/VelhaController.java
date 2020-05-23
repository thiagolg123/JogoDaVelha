package br.com.thiago.jogoDaVelha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.jogoDaVelha.DTO.Game;
import br.com.thiago.jogoDaVelha.service.GameService;

@RestController
@RequestMapping("/v1")
public class VelhaController {

	private Logger logger = LoggerFactory.getLogger(VelhaController.class);
	
	@Value("${message.game.draw}")
	private String DRAW;
	
	@Autowired
	private GameService gameService;
	
	@PostMapping("/jogovelha")
	public ResponseEntity<String> verificaJogo(@RequestBody Game recivedGame){
		try {
			List<Integer> valuesInTheGame = gameService.transformJsonInGame(recivedGame);
			String result = gameService.resolveGame(valuesInTheGame);
			if(result.equalsIgnoreCase(DRAW)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}else {
				return ResponseEntity.ok("Temos um ganhador: " +result);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	}
}
