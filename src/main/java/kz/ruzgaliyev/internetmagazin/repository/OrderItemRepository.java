package kz.ruzgaliyev.internetmagazin.repository;

import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    // Найти все OrderItem по ID заказа
    List<OrderItem> findByOrderId(Long orderId);
    // Найти все OrderItem по ID продукта
    List<OrderItem> findByProductId(Long productId);
    // Найти все OrderItem по цене
    List<OrderItem> findByPrice(double price);

}
