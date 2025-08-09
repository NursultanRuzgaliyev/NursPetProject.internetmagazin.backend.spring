package kz.ruzgaliyev.internetmagazin.serviceImpl;

import kz.ruzgaliyev.internetmagazin.entity.Category;
import kz.ruzgaliyev.internetmagazin.mapper.CategoryMapper;
import kz.ruzgaliyev.internetmagazin.repository.CategoryRepository;
import kz.ruzgaliyev.internetmagazin.requestDto.CategoryRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.CategoryResponseDto;
import kz.ruzgaliyev.internetmagazin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.toEntity(categoryRequestDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryResponseDto getCategorById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
                return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        Category updateCategory = categoryMapper.toEntity(categoryRequestDto);
        updateCategory.setId(id);

        Category savedCategory = categoryRepository.save(updateCategory);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if(!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponseDto> searchCategoriesByName(String categoryName) {
        return categoryRepository.findByNameContainingIgnoreCase(categoryName)
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
