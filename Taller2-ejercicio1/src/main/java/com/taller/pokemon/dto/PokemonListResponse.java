package com.taller.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonListResponse {

    private int count;
    private List<PokemonEntry> results;

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public List<PokemonEntry> getResults() { return results; }
    public void setResults(List<PokemonEntry> results) { this.results = results; }
}
