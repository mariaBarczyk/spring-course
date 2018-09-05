package com.mycompany.spring5webapp.bootstrap;

import com.mycompany.spring5webapp.model.Author;
import com.mycompany.spring5webapp.model.Book;
import com.mycompany.spring5webapp.repository.AuthorRepository;
import com.mycompany.spring5webapp.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeData();
    }

    private void initializeData() {

        Author hanna = new Author("Hanna", "Brown");
        Book algorithms = new Book("Algorithms", "123", "Paul Fox");
        hanna.getBooks().add(algorithms);
        algorithms.getAuthors().add(hanna);

        authorRepository.save(hanna);
        bookRepository.save(algorithms);

        Author derek  = new Author("Derek", "Geller");
        Book dataStructures = new Book("Data Structures", "158", "Paul Fox");
        derek.getBooks().add(dataStructures);
        dataStructures.getAuthors().add(derek);

        authorRepository.save(derek);
        bookRepository.save(dataStructures);
    }
}
