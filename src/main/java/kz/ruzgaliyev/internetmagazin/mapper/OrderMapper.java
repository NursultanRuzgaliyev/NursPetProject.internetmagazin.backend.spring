package kz.ruzgaliyev.internetmagazin.mapper;

import kz.ruzgaliyev.internetmagazin.entity.Order;
import kz.ruzgaliyev.internetmagazin.entity.OrderItem;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = OrderItemMapper.class)
public interface OrderMapper {
    @Mapping(source = "userId",target = "user.id")
    Order toEntity(OrderRequestDto dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.fullName",target = "userFullName")
    OrderResponseDto toDto(Order order);
}
