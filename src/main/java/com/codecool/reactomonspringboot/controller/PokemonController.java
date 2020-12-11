package com.codecool.reactomonspringboot.controller;

import com.codecool.reactomonspringboot.controller.service.RemoteURLReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

	private static final String DEFAULT_NUMBER_OF_ITEMS_PER_PAGE = "20";
	private final RemoteURLReader urlReader;

	public PokemonController(RemoteURLReader urlReader) {
		this.urlReader = urlReader;
	}

	@GetMapping("/pokemon")
	public String fetchPokemon(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = DEFAULT_NUMBER_OF_ITEMS_PER_PAGE) int limit) {
//		System.out.println(offset);
		System.out.println(limit + 50);
		return ("Hey, this is your first sample Pokemon for offset " + offset + " and limit " + limit);
	}

}
