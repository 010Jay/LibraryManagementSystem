package org.jay010.generic;

import java.util.List;

public interface IGenericCRUD<T, ID> {

        T create(T t);
        T read(ID id);
        T update(T t);
        boolean delete(ID id);
        List<T> getAll();
}
