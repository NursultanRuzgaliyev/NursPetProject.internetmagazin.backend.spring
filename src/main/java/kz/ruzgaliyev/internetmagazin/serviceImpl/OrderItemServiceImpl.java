package kz.ruzgaliyev.internetmagazin.serviceImpl;

import kz.ruzgaliyev.internetmagazin.entity.Order;
import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import kz.ruzgaliyev.internetmagazin.entity.Product;
import kz.ruzgaliyev.internetmagazin.mapper.OrderItemMapper;
import kz.ruzgaliyev.internetmagazin.repository.OrderItemRepository;
import kz.ruzgaliyev.internetmagazin.repository.OrderRepository;
import kz.ruzgaliyev.internetmagazin.repository.ProductRepository;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderItemRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderItemResponseDto;
import kz.ruzgaliyev.internetmagazin.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderItemResponseDto createOrderItem(OrderItemRequestDto orderItemRequestDto) {
        OrderItem orderItem = orderItemMapper.toEntity(orderItemRequestDto);
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(savedOrderItem);
    }

    @Override
    public OrderItemResponseDto getOrderItemById(Long orderItemId) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(()-> new RuntimeException("OrderItem can not found"));
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    public List<OrderItemResponseDto> getAllOrderItems() {
        return orderItemRepository.findAll()
                .stream()
                .map(orderItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemResponseDto updateOrderItem(Long id,OrderItemRequestDto orderItemRequestDto) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem can not found"));
        orderItem.setQuantity(orderItemRequestDto.getQuantity());
        orderItem.setPrice(orderItemRequestDto.getPrice());
        if (orderItemRequestDto.getProductId() != null) {
            Product product = productRepository.findById(orderItemRequestDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found" + orderItemRequestDto.getProductId()));
            orderItem.setProduct(product);
        }
        if (orderItemRequestDto.getOrderId() != null) {
            Order order = orderRepository.findById(orderItemRequestDto.getOrderId())
                    .orElseThrow(() -> new RuntimeException("Order can not found" + orderItemRequestDto.getOrderId()));
            orderItem.setOrder(order);
        }
        OrderItem updatedOrderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(updatedOrderItem);

    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        if(!orderItemRepository.existsById(orderItemId)) {
            throw new RuntimeException("");
        }
        orderItemRepository.deleteById(orderItemId);
    }
}
