package kz.ruzgaliyev.internetmagazin.responseDto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemResponseDto {
    private Long id;
    private int quantity;
    private double price;
    private Long productId;
    private String productName;
    private Long orderId;
}
