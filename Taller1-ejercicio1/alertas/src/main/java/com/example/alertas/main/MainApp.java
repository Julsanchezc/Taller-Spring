package com.example.alertas.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.alertas.config.AppConfig;
import com.example.alertas.interfaces.SistemaMonitoreo;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SistemaMonitoreo sistema = context.getBean(SistemaMonitoreo.class);

        sistema.ejecutar();
    }
}