package com.codecool.reactomonspringboot.controller;

import com.codecool.reactomonspringboot.controller.service.RemoteURLReader;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PokemonController {

	private static final String DEFAULT_NUMBER_OF_ITEMS_PER_PAGE = "20";
	private static final String POKEMON_API_ROOT = "https://pokeapi.co/api/v2/";
	private static final String POKEMON_IMAGE_ROOT = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
	private final RemoteURLReader urlReader;

	public PokemonController(RemoteURLReader urlReader) {
		this.urlReader = urlReader;
	}

	@GetMapping("/pokemon")
	public String fetchPokemons(@RequestParam(defaultValue = "0") int offset,
								@RequestParam(defaultValue = DEFAULT_NUMBER_OF_ITEMS_PER_PAGE) int limit,
								HttpServletResponse response) {
		String queryParametersForAPICall = "?offset=" + offset + "&limit=" + limit;
		try {
			return urlReader.readFromUrl(POKEMON_API_ROOT + "pokemon" + queryParametersForAPICall);
		} catch (IOException e) {
			response.setStatus(404);
			return "Could not fetch data";
		}
	}

	@GetMapping("/pokemon/{id}")
	public String fetchPokemonById(@PathVariable int id, HttpServletResponse response) {
		try {
			return urlReader.readFromUrl(POKEMON_API_ROOT + "pokemon/" + id);
		} catch (IOException e) {
			response.setStatus(404);
			return "Could not fetch data";
		}
	}

	@GetMapping("/type")
	public String fetchTypes(HttpServletResponse response) {
		try {
			return urlReader.readFromUrl(POKEMON_API_ROOT + "type");
		} catch (IOException e) {
			response.setStatus(404);
			return "Could not fetch data";
		}
	}

	@GetMapping("/pokemon/image/{id}")
	public String fetchImageForPokemon(@PathVariable int id, HttpServletResponse response) {
		try {
			String res = urlReader.readFromUrl(POKEMON_IMAGE_ROOT + id + ".png");
			System.out.println(res);
			return res;
		} catch (IOException e) {
			response.setStatus(404);
			return "Could not fetch data";
		}
	}

}
