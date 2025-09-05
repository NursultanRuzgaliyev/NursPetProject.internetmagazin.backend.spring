package kz.ruzgaliyev.internetmagazin.responseDto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderResponseDto {
    private Long id;
    private LocalDateTime orderDate;
    private double totalPrice;
    private Long userId;
    private List<OrderItemResponseDto> items;

}
