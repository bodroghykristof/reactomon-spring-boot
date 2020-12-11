package com.codecool.reactomonspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

	@GetMapping("/pokemon")
	public String fetchPokemon() {
		return ("Hey, this is your first sample Pokemon");
	}

}
