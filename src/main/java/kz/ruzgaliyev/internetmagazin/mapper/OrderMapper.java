package kz.ruzgaliyev.internetmagazin.mapper;

import kz.ruzgaliyev.internetmagazin.entity.Order;
import kz.ruzgaliyev.internetmagazin.requestDto.OrderRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { OrderItemMapper.class })
public interface OrderMapper {
    @Mapping(source = "user.id", target = "userId")
    OrderResponseDto toDto(Order entity);

    @Mapping(source = "userId", target = "user.id")
    Order toEntity(OrderRequestDto dto);
}

