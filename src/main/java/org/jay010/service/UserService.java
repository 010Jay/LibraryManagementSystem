package org.jay010.service;

import org.jay010.entity.User;
import org.jay010.generic.IGenericCRUD;
import org.jay010.repository.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IGenericCRUD<User, Integer> {

    @Autowired
    private UserRepository repository;
    private static UserService service = null;

    public static UserService getService() {
        if(service == null)
            service = new UserService();

        return service;
    }

    @Override
    public User create(User user) {
        return repository.create(user);
    }

    @Override
    public User read(Integer id) {
        return repository.read(id);
    }

    @Override
    public User update(User user) {
        return repository.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
