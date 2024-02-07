package dev.craftlr.exercice2.model;

import static java.lang.String.format;

import java.util.List;
import java.util.stream.Collectors;

public class Pokemon {

    private static final String BASE_IMAGE_URL = "https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/";
    private static final String IMAGE_EXTENSION = ".svg";

    private final int id;
    private final String name;
    private final List<PokemonType> types;
    private final String spriteURL;

    public Pokemon(int id, String name, PokemonType... types) {
        this.id = id;
        this.name = name;
        this.types = List.of(types);
        this.spriteURL = format("%s%d%s", BASE_IMAGE_URL, this.id, IMAGE_EXTENSION);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public String getSpriteURL() {
        return spriteURL;
    }

    @Override
    public String toString() {
        return format("%d: %s (Type: %s)", id, name,
                types.stream().map(Enum::name).collect(Collectors.joining("/")));
    }
}
