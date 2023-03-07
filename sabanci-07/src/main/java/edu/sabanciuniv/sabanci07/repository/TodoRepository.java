package edu.sabanciuniv.sabanci07.repository;

import edu.sabanciuniv.sabanci07.model.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
