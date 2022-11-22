package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Books;
import com.example.obrestdatajpa.repositories.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);
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
    public ResponseEntity<Books> create(@RequestBody Books book) {
        //guardar el libro recibido
        if (book.getId() != null) {
            log.warn("Trying to create a book with ID");
            return ResponseEntity.badRequest().build();
        }
        Books result = booksRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //actualizar un libro existente
    @PutMapping("/api/books")
    public ResponseEntity<Books> update(@RequestBody Books book) {
        if (book.getId() == null) {
            log.warn("Trying to update a book without ID");
            return ResponseEntity.badRequest().build();
        }
        if(!booksRepository.existsById(book.getId())) {
            log.warn("Trying to update a non existing book");
            return ResponseEntity.notFound().build();
        }
        booksRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Borrar un libro en base de datos
    @DeleteMapping("api/books/{id}")
    public ResponseEntity<Books> delete(@PathVariable Long id) {

        if(!booksRepository.existsById(id)) {
            log.warn("Trying to delete a non existing book");
            return ResponseEntity.notFound().build();
        }
        booksRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Books> deleteAll() {
        log.debug("REST Request for Delete all books");
        booksRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
