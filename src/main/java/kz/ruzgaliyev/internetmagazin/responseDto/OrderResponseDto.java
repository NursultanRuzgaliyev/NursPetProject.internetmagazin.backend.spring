package kz.ruzgaliyev.internetmagazin.responseDto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private LocalDateTime orderDate;
    private double totalPrice;
    private Long userId;
    private String userFullName;
    private List<OrderItemResponseDto> items;

}
