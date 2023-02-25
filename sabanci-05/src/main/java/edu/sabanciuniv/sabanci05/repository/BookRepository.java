package edu.sabanciuniv.sabanci05.repository;

import edu.sabanciuniv.sabanci05.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
