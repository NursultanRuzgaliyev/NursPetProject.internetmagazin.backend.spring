package kz.ruzgaliyev.internetmagazin.serviceImpl;

import kz.ruzgaliyev.internetmagazin.entity.Order;
import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import kz.ruzgaliyev.internetmagazin.mapper.OrderMapper;
import kz.ruzgaliyev.internetmagazin.repository.OrderItemRepository;
import kz.ruzgaliyev.internetmagazin.repository.OrderRepository;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderItemRequestDto;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderResponseDto;
import kz.ruzgaliyev.internetmagazin.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.toEntity(orderRequestDto);
        Order ordersaved = orderRepository.save(order);
        return orderMapper.toDto(ordersaved);
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDto updateOrder(Long id, OrderRequestDto orderRequestDto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        if (orderRequestDto.getOrderDate()!=null) {
            order.setOrderDate(orderRequestDto.getOrderDate());
        }
        order.setTotalPrice(orderRequestDto.getTotalPrice());
        if(orderRequestDto.getItems()!=null && !orderRequestDto.getItems().isEmpty()) {
            List<OrderItem> updatedItems = new ArrayList<>();
            for(OrderItemRequestDto itemId:orderRequestDto.getItems()){
                OrderItem  orderItem = orderItemRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("OrderItem not found"));
                updatedItems.add(orderItem);
            }
            order.setItems(updatedItems);
        }
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public void deleteOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }
}
