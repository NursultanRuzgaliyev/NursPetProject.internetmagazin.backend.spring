package kz.ruzgaliyev.internetmagazin.mapper;

import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderItemRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "orderId", target = "order.id")
    OrderItem toEntity(OrderItemRequestDto dto);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "order.id", target = "orderId")
    OrderItemResponseDto toDto(OrderItem entity);
}
