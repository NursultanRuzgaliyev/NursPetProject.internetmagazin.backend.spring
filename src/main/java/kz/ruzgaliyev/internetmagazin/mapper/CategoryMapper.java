package kz.ruzgaliyev.internetmagazin.mapper;


import kz.ruzgaliyev.internetmagazin.entity.Category;
import kz.ruzgaliyev.internetmagazin.requestDto.CategoryRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.CategoryResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = ProductMapper.class)
public interface CategoryMapper {
    Category toEntity (CategoryRequestDto dto);
    CategoryResponseDto toDto (Category category);
}
