package com.example.alertas.impl;

import com.example.alertas.interfaces.GeneradorAlerta;
import com.example.alertas.interfaces.SistemaMonitoreo;

public class SistemaMonitoreoImpl implements SistemaMonitoreo {

    private GeneradorAlerta generadorAlerta;

    // Inyección por constructor
    public SistemaMonitoreoImpl(GeneradorAlerta generadorAlerta) {
        this.generadorAlerta = generadorAlerta;
    }

    @Override
    public void ejecutar() {
        System.out.println(generadorAlerta.generarAlerta());
    }
}