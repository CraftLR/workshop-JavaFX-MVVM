package dev.craftlr.exercice2.model;

import java.util.List;

public class PokemonService {

    List<Pokemon> pokemons = List.of(
            new Pokemon(0, "Glitch", "None"),
            new Pokemon(1, "Bulbasaur", "Grass/Poison"),
            new Pokemon(2, "Ivysaur", "Grass/Poison"),
            new Pokemon(3, "Venusaur", "Grass/Poison"),
            new Pokemon(4, "Charmander", "Fire"),
            new Pokemon(5, "Charmeleon", "Fire"),
            new Pokemon(6, "Charizard", "Fire/Flying"));

    Iterable<Pokemon> getPokemons() {
        return pokemons;
    }

    Pokemon getPokemonsById(int id) {
        return pokemons.get(id);
    }
}
