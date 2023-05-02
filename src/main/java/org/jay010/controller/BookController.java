package org.jay010.controller;

import org.jay010.entity.Book;
import org.jay010.generic.IGenericCRUD;
import org.jay010.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController implements IGenericCRUD<Book, Integer> {

    @Autowired
    private BookService service;

    @Override
    @PostMapping("/create")
    public Book create(@RequestBody Book book) {
        return service.create(book);
    }

    @Override
    @GetMapping("/read/{id}")
    public Book read(@PathVariable Integer id) {
        return service.read(id);
    }

    @Override
    @PostMapping("/update")
    public Book update(@RequestBody Book book) {
        return service.update(book);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<Book> getAll() {
        return service.getAll();
    }
}
