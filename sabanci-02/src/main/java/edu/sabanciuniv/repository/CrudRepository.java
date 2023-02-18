package edu.sabanciuniv.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T find(int id);
    void save(T object);
    void delete(T object);
    void delete(int id);
    void update(T object, int id);
}
