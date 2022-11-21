package org.example;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

    public CalculatorService() {
        System.out.println("Ejecutando contructor calculator service");
    }

    public String holaMundo() {
        return "Hola Mundo";
    }
}
