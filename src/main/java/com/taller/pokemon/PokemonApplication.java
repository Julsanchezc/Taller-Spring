package com.taller.pokemon;

import com.taller.pokemon.service.PokemonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PokemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PokemonService pokemonService) {
        return args -> pokemonService.mostrarPokemones();
    }
}
