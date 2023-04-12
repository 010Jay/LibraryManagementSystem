package org.jay010.repository;

public interface IRepository<T,ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
    T[] getAll();
    int getSize();
}
