package kz.ruzgaliyev.internetmagazin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
}
