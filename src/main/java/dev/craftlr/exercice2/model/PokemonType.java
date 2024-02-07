package dev.craftlr.exercice2.model;

public enum PokemonType {
    GRASS("Grass"),
    POISON("Poison"),
    FIRE("Fire"),
    WATER("Water"),
    ELECTRIC("Electric"),
    PSYCHIC("Psychic"),
    ICE("Ice"),
    DRAGON("Dragon"),
    NORMAL("Normal"),
    FIGHTING("Fighting"),
    FLYING("Flying"),
    GROUND("Ground"),
    ROCK("Rock"),
    BUG("Bug"),
    GHOST("Ghost"),
    STEEL("Steel"),
    FAIRY("Fairy");

    private final String typeName;

    PokemonType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
