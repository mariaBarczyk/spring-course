package com.mycompany.spring5webapp.bootstrap;

import com.mycompany.spring5webapp.model.Author;
import com.mycompany.spring5webapp.model.Book;
import com.mycompany.spring5webapp.model.Publisher;
import com.mycompany.spring5webapp.repository.AuthorRepository;
import com.mycompany.spring5webapp.repository.BookRepository;
import com.mycompany.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeData();
    }

    private void initializeData() {

        Author hanna = new Author("Hanna", "Brown");
        Publisher paul = new Publisher("Paul","Roseville 19");
        Book algorithms = new Book("Algorithms", "123", paul);

        hanna.getBooks().add(algorithms);
        algorithms.getAuthors().add(hanna);

        authorRepository.save(hanna);
        publisherRepository.save(paul);
        bookRepository.save(algorithms);



        Author derek  = new Author("Derek", "Geller");
        Publisher megan  = new Publisher("Megan","Santa Rosa 21");
        Book dataStructures = new Book("Data Structures", "158", megan);

        derek.getBooks().add(dataStructures);
        dataStructures.getAuthors().add(derek);

        authorRepository.save(derek);
        publisherRepository.save(megan);
        bookRepository.save(dataStructures);

    }
}
