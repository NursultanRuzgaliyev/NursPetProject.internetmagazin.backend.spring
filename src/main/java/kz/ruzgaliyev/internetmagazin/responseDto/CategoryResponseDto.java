package kz.ruzgaliyev.internetmagazin.responseDto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CategoryResponseDto {
    private Long id;
    private String name;
    private List<ProductResponseDto> products;
}
