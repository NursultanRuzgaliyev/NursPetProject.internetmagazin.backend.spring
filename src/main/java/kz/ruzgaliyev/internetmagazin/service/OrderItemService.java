package kz.ruzgaliyev.internetmagazin.service;

import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderItemRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderItemResponseDto;

import java.util.List;

public interface OrderItemService {
    OrderItemResponseDto createOrderItem(OrderItemRequestDto orderItemRequestDto);
    OrderItemResponseDto getOrderItemById(Long orderId);
    List<OrderItemResponseDto> getAllOrderItems();
    OrderItemResponseDto updateOrderItem(Long id,OrderItemRequestDto orderItemRequestDto);
    void deleteOrderItem(Long orderItemId);

}
