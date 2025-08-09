package kz.ruzgaliyev.internetmagazin.responseDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String categoryName;
}
