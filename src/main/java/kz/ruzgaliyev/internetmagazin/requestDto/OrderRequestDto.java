package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderRequestDto {
    private LocalDateTime orderDate;
    private double totalPrice;
    private Long userId;
    private List<OrderItemRequestDto> items;
}
