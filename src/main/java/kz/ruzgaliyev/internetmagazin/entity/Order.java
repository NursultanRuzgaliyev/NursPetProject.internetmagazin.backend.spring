package kz.ruzgaliyev.internetmagazin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate = LocalDateTime.now();
    private double totalPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderItem> items = new ArrayList<>();
}
