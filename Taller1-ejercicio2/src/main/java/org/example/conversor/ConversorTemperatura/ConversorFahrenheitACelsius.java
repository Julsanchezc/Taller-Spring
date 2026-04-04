package org.example.conversor.ConversorTemperatura;

import org.example.conversor.Conversor;
import org.springframework.stereotype.Component;

//@Component
public class ConversorFahrenheitACelsius implements Conversor {

    @Override
    public double convertir(double valor) {
        return (valor - 32) * 5/9;
    }
}
