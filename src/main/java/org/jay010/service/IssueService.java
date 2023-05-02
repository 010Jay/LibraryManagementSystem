package org.jay010.service;

import org.jay010.entity.Issue;
import org.jay010.generic.IGenericCRUD;
import org.jay010.repository.impl.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService implements IGenericCRUD<Issue, Integer> {

    @Autowired
    private IssueRepository repository;
    private static IssueService service = null;

    public static IssueService getService() {
        if(service == null)
            service = new IssueService();

        return service;
    }

    @Override
    public Issue create(Issue issue) {
        return repository.create(issue);
    }

    @Override
    public Issue read(Integer id) {
        return repository.read(id);
    }

    @Override
    public Issue update(Issue issue) {
        return repository.update(issue);
    }

    @Override
    public boolean delete(Integer id
    ) {
        return repository.delete(id);
    }

    @Override
    public List<Issue> getAll() {
        return repository.getAll();
    }
}
