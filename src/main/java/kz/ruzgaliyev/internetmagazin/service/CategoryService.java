package kz.ruzgaliyev.internetmagazin.service;

import kz.ruzgaliyev.internetmagazin.requestDto.CategoryRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto getCategorById(Long id);
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto updateCategory(Long id,CategoryRequestDto categoryRequestDto);
    void deleteCategory(Long id);
    List<CategoryResponseDto> searchCategoriesByName(String categoryName);
}
