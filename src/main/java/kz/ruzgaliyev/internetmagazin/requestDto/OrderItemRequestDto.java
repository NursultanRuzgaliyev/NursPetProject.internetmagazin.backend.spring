package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderItemRequestDto {
    private int quantity;
    private double price;
    private Long productId;
    private Long orderId;
}
