package org.jay010.service.impl;

import org.jay010.entity.Book;
import org.jay010.repository.impl.BookRepository;
import org.jay010.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private static BookService service = null;
    @Autowired
    private BookRepository repository;

    public static BookService getService() {
        if(service == null) {
            service = new BookService();
        }

        return service;
    }

    @Override
    public Book create(Book book) {
        return repository.create(book);
    }

    @Override
    public Book read(Integer id) {
        return repository.read(id);
    }

    @Override
    public Book update(Book book) {
        return repository.update(book);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    @Override
    public List<Book> getAll() {
        return repository.getAll();
    }
}
