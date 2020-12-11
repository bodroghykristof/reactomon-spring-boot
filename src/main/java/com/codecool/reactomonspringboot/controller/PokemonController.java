package com.codecool.reactomonspringboot.controller;

import com.codecool.reactomonspringboot.controller.service.RemoteURLReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PokemonController {

	private static final String DEFAULT_NUMBER_OF_ITEMS_PER_PAGE = "20";
	private static final String POKEMON_API_ROOT = "https://pokeapi.co/api/v2/";
	private final RemoteURLReader urlReader;

	public PokemonController(RemoteURLReader urlReader) {
		this.urlReader = urlReader;
	}

	@GetMapping("/pokemon")
	public String fetchPokemon(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = DEFAULT_NUMBER_OF_ITEMS_PER_PAGE) int limit) {
		String queryParametersForAPICall = "?offset=" + offset + "&limit=" + limit;
		try {
			return urlReader.readFromUrl(POKEMON_API_ROOT + "pokemon" + queryParametersForAPICall);
		} catch (IOException e) {
			return "Could not fetch data";
		}
	}

}
