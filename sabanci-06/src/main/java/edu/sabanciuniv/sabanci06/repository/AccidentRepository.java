package edu.sabanciuniv.sabanci06.repository;

import edu.sabanciuniv.sabanci06.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Integer> {
}
