package org.jay010.controller;

import org.jay010.entity.Issue;
import org.jay010.generic.IGenericCRUD;
import org.jay010.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
@CrossOrigin("*")
public class IssueController implements IGenericCRUD<Issue, Integer> {

    @Autowired
    private IssueService service;

    @Override
    @PostMapping("/create")
    public Issue create(@RequestBody Issue issue) {
        return service.create(issue);
    }

    @Override
    @GetMapping("/read/{id}")
    public Issue read(@PathVariable Integer id) {
        return service.read(id);
    }

    @Override
    public Issue update(Issue issue) {
        return null;
    }

    @PostMapping("/update")
    public Issue update(@RequestBody Issue issue, @RequestParam("calculateFine") Boolean calculateFine) {
        return service.update(issue, calculateFine);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<Issue> getAll() {
        return service.getAll();
    }
}
