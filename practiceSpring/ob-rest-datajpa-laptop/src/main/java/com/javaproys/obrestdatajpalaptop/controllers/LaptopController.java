package com.javaproys.obrestdatajpalaptop.controllers;

import com.javaproys.obrestdatajpalaptop.entities.Laptop;
import com.javaproys.obrestdatajpalaptop.repositories.LaptopRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRespository laptopRespository;

    public LaptopController(LaptopRespository laptopRespository) {
        this.laptopRespository = laptopRespository;
    }
    //CRUD
    //Crear una Laptop
    @PostMapping("/api/laptops")
    public Laptop postLaptop(@RequestBody Laptop laptop) {
        return laptopRespository.save(laptop);
    }

    //Consultar todas las Laptop
    @GetMapping("/api/laptops")
    public List<Laptop> getLaptops() {
        return laptopRespository.findAll();
    }

    //Consultar por ID
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> getLaptopsById(@PathVariable Long id) {
        Optional<Laptop> laptopOptional = laptopRespository.findById(id);
        if (laptopOptional.isPresent()) return ResponseEntity.ok(laptopOptional.get());
        return ResponseEntity.notFound().build();
    }

}
