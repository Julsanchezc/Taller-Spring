package com.taller.pokemon.service;

import com.taller.pokemon.dto.PokemonDetail;
import com.taller.pokemon.dto.PokemonEntry;
import com.taller.pokemon.dto.PokemonListResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que consume la PokeAPI para obtener información de múltiples Pokémon.
 */
@Service
public class PokemonService {

    private static final String BASE_URL   = "https://pokeapi.co/api/v2";
    private static final int    LIMIT      = 5;   // Mínimo requerido por el taller

    private final RestTemplate restTemplate;

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Punto de entrada principal: obtiene la lista y luego el detalle de cada Pokémon.
     */
    public void mostrarPokemones() {
        System.out.println("=".repeat(55));
        System.out.println("        TALLER 2 - Consumo de API con Spring");
        System.out.println("=".repeat(55));

        // 1. Llamada al endpoint de lista  →  1 llamada HTTP
        PokemonListResponse lista = obtenerLista();

        System.out.printf("Total de Pokémon en la API: %d%n", lista.getCount());
        System.out.printf("Obteniendo los primeros %d...%n%n", LIMIT);

        // 2. Por cada Pokémon: llamada al endpoint de detalle  →  N llamadas HTTP
        for (PokemonEntry entry : lista.getResults()) {
            PokemonDetail detalle = obtenerDetalle(entry.getUrl());
            imprimirDetalle(detalle);
        }

        System.out.println("=".repeat(55));
        System.out.printf("Total de llamadas HTTP realizadas: %d%n", 1 + LIMIT);
    }

    /**
     * Llama a /pokemon?limit=N y retorna la respuesta mapeada al DTO.
     */
    private PokemonListResponse obtenerLista() {
        String url = BASE_URL + "/pokemon?limit=" + LIMIT;
        return restTemplate.getForObject(url, PokemonListResponse.class);
    }

    /**
     * Llama al endpoint de detalle de un Pokémon usando la URL que ya viene en la lista.
     * Esto responde la pregunta 1: la URL de detalle viene en el campo "url" de cada entry.
     */
    private PokemonDetail obtenerDetalle(String url) {
        return restTemplate.getForObject(url, PokemonDetail.class);
    }

    /**
     * Imprime la información del Pokémon de forma estructurada (no JSON crudo).
     */
    private void imprimirDetalle(PokemonDetail p) {
        // Extraer los nombres de los tipos
        List<String> tipos = p.getTypes().stream()
                .map(t -> t.getType().getName())
                .collect(Collectors.toList());

        // Extraer los nombres de las habilidades
        List<String> habilidades = p.getAbilities().stream()
                .map(a -> a.getAbility().getName())
                .collect(Collectors.toList());

        // Convertir peso de hectogramos a kg y altura de decímetros a metros
        double pesoKg    = p.getWeight() / 10.0;
        double alturaM   = p.getHeight() / 10.0;

        System.out.println("-".repeat(55));
        System.out.printf("Nombre     : %s%n",       capitalize(p.getName()));
        System.out.printf("Tipos      : %s%n",       String.join(", ", tipos));
        System.out.printf("Habilidades: %s%n",       String.join(", ", habilidades));
        System.out.printf("Peso       : %.1f kg%n",  pesoKg);
        System.out.printf("Altura     : %.1f m%n",   alturaM);
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
