package edu.sabanciuniv.sabanci05.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_order")
@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode
//@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String orderId;
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    @JsonManagedReference
    private Set<Book> bookList = new HashSet<>();

    public Order(String orderId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
}
