package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Books;
import com.example.obrestdatajpa.repositories.BooksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {


    //atributos
    private BooksRepository booksRepository;
    //inyeccion de dependencia usando contructores
    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    //CRUD sobre books
    //Buscar todos los libros(lista)

    /**
     * http://localhost:8080/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Books> findAll(){
        //recuperar y devolver los librso de base de datos
        return booksRepository.findAll();
    }

    //Buscar un solo libro segun id
    /**
     * http://localhost:8080/api/books/{id}
     * @return
     */
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Books> findOneById(@PathVariable Long id) {
        Optional<Books> booksOptional = booksRepository.findById(id);
        /*
        * Opcion 1: Devolver una entidad Book o devolver null
        * return booksOptional.orElse(null);
        * Option 2: Onliner Response Entity
        * return booksOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        * */
        if (booksOptional.isPresent())return ResponseEntity.ok(booksOptional.get());
        return ResponseEntity.notFound().build();
    }
    //Crear nuevo libro en base de datos
    /**
     * http://localhost:8080/api/books
     * @return
     */
    @PostMapping("/api/books")
    public Books create(@RequestBody Books book) {
        //guardar el libro recibido
        return booksRepository.save(book);
    }
    //actualizar un libro existente

    //Borrar un libro en base de datos

}
