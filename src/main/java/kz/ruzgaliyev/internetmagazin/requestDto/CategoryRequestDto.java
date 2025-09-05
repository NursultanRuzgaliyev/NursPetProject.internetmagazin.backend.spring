package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDto {
    private String name;
    private List<ProductRequestDto> products;
}
