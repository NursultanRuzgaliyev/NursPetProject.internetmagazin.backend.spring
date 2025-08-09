package kz.ruzgaliyev.internetmagazin.mapper;

import kz.ruzgaliyev.internetmagazin.entity.Product;
import kz.ruzgaliyev.internetmagazin.requestDto.ProductRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface ProductMapper {
    @Mapping(source = "category.name",target="categoryName")
    ProductResponseDto toDto(Product product);

    @Mapping(source = "categoryId",target = "category.id")
    Product toEntity(ProductRequestDto productRequestDto);
}
