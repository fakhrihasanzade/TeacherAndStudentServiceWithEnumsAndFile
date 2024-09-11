package service;

import java.util.List;

public interface CommonService<T> {

    void add(T object);

    List<T> getAll();

    T getById(Integer id);

    void updateById(Integer id, T object);

    void deleteById(Integer id);


}
