package kz.ruzgaliyev.internetmagazin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orderItem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;
}
