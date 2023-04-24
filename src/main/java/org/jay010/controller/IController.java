package org.jay010.controller;

import java.util.List;

public interface IController<T, ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
    List<T> getAll();
}
