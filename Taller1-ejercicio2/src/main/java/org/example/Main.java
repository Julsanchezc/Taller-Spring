package org.example;

import org.example.service.ConversorApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("org.example");

        ConversorApp app = context.getBean(ConversorApp.class);

        app.ejecutar();
        context.close();
    }
}
