package org.jay010.controller.impl;

import org.jay010.controller.IController;
import org.jay010.entity.User;
import org.jay010.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements IController<User, Integer> {

    @Autowired
    private UserService service;

    @Override
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @Override
    @GetMapping("/read/{id}")
    public User read(@PathVariable Integer id) {
        return service.read(id);
    }

    @Override
    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<User> getAll() {
        return service.getAll();
    }
}
