package kz.ruzgaliyev.internetmagazin.repository;

import kz.ruzgaliyev.internetmagazin.entity.Order;
import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByOrderDate(LocalDateTime orderDate);
    List<Order> findByTotalPrice(double totalPrice);
}
