package kz.ruzgaliyev.internetmagazin.service;

import kz.ruzgaliyev.internetmagazin.requestDto.OrderRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    OrderResponseDto getOrderById(Long id);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto updateOrder(Long id, OrderRequestDto orderRequestDto);

    void deleteOrderById(Long id);
}