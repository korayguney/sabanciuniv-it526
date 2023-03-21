package edu.sabanci.sabanciexam.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConversionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String transactionId;
    private LocalDateTime transactionDate;
    private double amount;
    private double calculatedAmount;

    @OneToOne
    private CurrencyEntity entity;

}
