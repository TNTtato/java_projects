package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    CalculatorService calculatorService;

    public GestorFacturas(CalculatorService calculatorService) {
        System.out.println("Ejecutando contructor GestorFacturas");
        this.calculatorService = calculatorService;
        //this.nombre = nombre;
    }
}
