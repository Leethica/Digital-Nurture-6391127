package com.example.library;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SpringBootApplication
public class LibraryApp1 implements CommandLineRunner {

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }

    @Override
    public void run(String[] args) {
        repository.save(new Book("Spring Boot", "Rod Johnson"));
        repository.save(new Book("Effective Java", "Joshua Bloch"));
        List<Book> books = repository.findAll();
        books.forEach(System.out::println);
    }

    @Entity
    static class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String author;

        public Book() {} 
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{id=" + id + ", title='" + title + "', author='" + author + "'}";
        }
    }

    @Repository
    interface BookRepository extends JpaRepository<Book, Long> {}
}
