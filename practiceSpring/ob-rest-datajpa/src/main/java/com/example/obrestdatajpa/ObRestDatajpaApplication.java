package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Books;
import com.example.obrestdatajpa.repositories.BooksRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		/*ApplicationContext context = */SpringApplication.run(ObRestDatajpaApplication.class, args);
		//BooksRepository repository = context.getBean(BooksRepository.class);
		/*
		//CRUD
		//Crear un libro
		Books books1 = new Books(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1), true);
		Books books2 = new Books(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(2013, 12, 1), true);
		//Almacenar un libreo
		repository.save(books1);
		repository.save(books2);
		//recuperar todos los libros
		System.out.println("Libros en base de datos");
		System.out.println(repository.findAll());
		//borrar un libro
		repository.deleteById(1L);
		System.out.println("Libros en base de datos despues de borrar 1");
		System.out.println(repository.findAll());

		 */
	}

}
