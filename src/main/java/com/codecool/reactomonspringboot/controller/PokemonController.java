package com.codecool.reactomonspringboot.controller;

import com.codecool.reactomonspringboot.controller.service.RemoteURLReader;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PokemonController {

	private static final String DEFAULT_NUMBER_OF_ITEMS_PER_PAGE = "20";
	private static final String POKEMON_API_ROOT = "https://pokeapi.co/api/v2/";
	private final RemoteURLReader urlReader;

	public PokemonController(RemoteURLReader urlReader) {
		this.urlReader = urlReader;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/pokemon")
	public String fetchPokemons(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = DEFAULT_NUMBER_OF_ITEMS_PER_PAGE) int limit) {
		String queryParametersForAPICall = "?offset=" + offset + "&limit=" + limit;
		try {
			return urlReader.readFromUrl(POKEMON_API_ROOT + "pokemon" + queryParametersForAPICall);
		} catch (IOException e) {
			return "Could not fetch data";
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/pokemon/{id}")
	public String fetchPokemonById(@PathVariable int id, HttpServletResponse response) {
		try {
			return urlReader.readFromUrl(POKEMON_API_ROOT + "pokemon/" + id);
		} catch (IOException e) {
			response.setStatus(404);
			return "Could not fetch data";
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/type")
	public String fetchTypes() {
		try {
			return urlReader.readFromUrl(POKEMON_API_ROOT + "type");
		} catch (IOException e) {
			return "Could not fetch data";
		}
	}

}
