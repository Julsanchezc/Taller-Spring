package com.example.alertas.impl;

import com.example.alertas.interfaces.GeneradorAlerta;

public class AlertaInformativa implements GeneradorAlerta {

    @Override
    public String generarAlerta() {
        return "ℹ️ ALERTA INFORMATIVA: Todo funciona correctamente";
    }
}