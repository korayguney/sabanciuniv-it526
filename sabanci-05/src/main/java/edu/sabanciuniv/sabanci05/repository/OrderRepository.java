package edu.sabanciuniv.sabanci05.repository;

import edu.sabanciuniv.sabanci05.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.orderId =:orderId")
    Order findOrderByOrderId(String orderId);

}
