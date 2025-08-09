package kz.ruzgaliyev.internetmagazin.mapper;

import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderItemRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(source = "product.id",target = "productId")
    @Mapping(source = "order.id",target = "orderId")
    @Mapping(source = "product.name",target = "productName")
    OrderItemResponseDto toOrderItemResponseDto(OrderItem orderItem);

    @Mapping(source = "productId",target = "product.id")
    @Mapping(source = "orderId",target = "order.id")
    @Mapping(source = "productId",target = "product.id")
    OrderItem toEntity(OrderItemRequestDto orderItemRequestDto);


}
