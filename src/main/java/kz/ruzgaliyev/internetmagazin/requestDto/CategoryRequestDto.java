package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDto {
    private String name;
    private List<ProductRequestDto> products;
}
