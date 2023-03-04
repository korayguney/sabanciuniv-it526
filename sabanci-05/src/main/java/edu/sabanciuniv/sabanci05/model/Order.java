package edu.sabanciuniv.sabanci05.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ordertable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@EqualsAndHashCode
//@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private UUID orderId;
    private LocalDateTime orderDate;

    @ManyToMany
    //@JsonManagedReference
   // @Column(name = "books")
    private Set<Book> bookList = new HashSet<>();

    public Order(UUID orderId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
}
