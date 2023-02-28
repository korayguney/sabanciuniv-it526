package edu.sabanciuniv.sabanci06.repository;

import edu.sabanciuniv.sabanci06.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
