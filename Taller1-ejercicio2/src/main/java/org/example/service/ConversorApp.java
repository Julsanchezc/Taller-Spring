package org.example.service;

import org.example.conversor.Conversor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConversorApp {

    private final Conversor conversor;

    public ConversorApp(
            @Qualifier("conversorFahrenheitACelsius") Conversor conversor) {
        this.conversor = conversor;
    }

    public void ejecutar() {
        double valor = 100;

        double resultado = conversor.convertir(valor);

        System.out.println("Conversor usado: " + conversor.getClass().getSimpleName());
        System.out.println("Resultado: " + resultado);
    }
}