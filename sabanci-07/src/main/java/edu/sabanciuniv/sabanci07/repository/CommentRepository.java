package edu.sabanciuniv.sabanci07.repository;

import edu.sabanciuniv.sabanci07.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
