package org.example.conversor.ConversorDistancia;

import org.example.conversor.Conversor;
import org.springframework.stereotype.Component;

@Component
public class ConversorKmAMillas implements Conversor {

    @Override
    public double convertir(double valor) {
        return valor * 0.621371;
    }
}