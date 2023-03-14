package edu.sabanciuniv.sabanci07.repository;

import edu.sabanciuniv.sabanci07.model.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
    // method-driven query
    // select * from todo_entity where todoId=1
    TodoEntity getTodoEntityByTodoId(Integer todoId);
    List<TodoEntity> getByCompleted(Boolean booleanValue);
}
