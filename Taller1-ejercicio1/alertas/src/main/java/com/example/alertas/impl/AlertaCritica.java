package com.example.alertas.impl;

import com.example.alertas.interfaces.GeneradorAlerta;

public class AlertaCritica implements GeneradorAlerta {

    @Override
    public String generarAlerta() {
        return "🚨 ALERTA CRÍTICA: Se detectó un problema grave";
    }
}