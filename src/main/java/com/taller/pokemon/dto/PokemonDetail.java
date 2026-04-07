package com.taller.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDetail {

    private String name;
    private int weight;
    private int height;

    @JsonProperty("types")
    private List<TypeSlot> types;

    @JsonProperty("abilities")
    private List<AbilitySlot> abilities;

    // --- Getters y Setters ---

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public List<TypeSlot> getTypes() { return types; }
    public void setTypes(List<TypeSlot> types) { this.types = types; }

    public List<AbilitySlot> getAbilities() { return abilities; }
    public void setAbilities(List<AbilitySlot> abilities) { this.abilities = abilities; }

    // --- Clases internas para mapear la estructura anidada de la API ---

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TypeSlot {
        private TypeInfo type;

        public TypeInfo getType() { return type; }
        public void setType(TypeInfo type) { this.type = type; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TypeInfo {
        private String name;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AbilitySlot {
        private AbilityInfo ability;

        public AbilityInfo getAbility() { return ability; }
        public void setAbility(AbilityInfo ability) { this.ability = ability; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AbilityInfo {
        private String name;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
