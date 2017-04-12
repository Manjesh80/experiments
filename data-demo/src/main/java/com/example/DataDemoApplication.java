package com.example;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DataDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(DataDemoApplication.class, args);

        Book book = new Book();
        book.name = "Jai Ganesh";
        book.releaseDate = Calendar.getInstance().getTime();
        Set<Author> authors = new HashSet<>();
        final Author author = new Author();
        author.name = "David";
        authors.add(author);
        book.authors = authors;

        BookRepository bookRepository = applicationContext.getBean(BookRepository.class);
        book = bookRepository.save(book);

        final List<Book> all = bookRepository.findAll();

        System.out.println(all);
    }
}
