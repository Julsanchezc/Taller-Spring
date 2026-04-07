package com.example.alertas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.alertas.impl.AlertaCritica;
import com.example.alertas.impl.SistemaMonitoreoImpl;
import com.example.alertas.interfaces.GeneradorAlerta;
import com.example.alertas.interfaces.SistemaMonitoreo;

@Configuration
public class AppConfig {

    @Bean
    public GeneradorAlerta generadorAlerta() {
        return new AlertaCritica();
    }

    @Bean
    public SistemaMonitoreo sistemaMonitoreo() {
        return new SistemaMonitoreoImpl(generadorAlerta());
    }
}