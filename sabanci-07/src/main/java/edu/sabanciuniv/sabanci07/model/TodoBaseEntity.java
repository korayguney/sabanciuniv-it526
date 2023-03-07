package edu.sabanciuniv.sabanci07.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class TodoBaseEntity {
    private LocalDateTime queriedDate;
}
