package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProductRequestDto {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Long categoryId;
}
