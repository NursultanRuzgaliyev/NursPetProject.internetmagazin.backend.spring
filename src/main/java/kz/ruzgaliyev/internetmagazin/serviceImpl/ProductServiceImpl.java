package kz.ruzgaliyev.internetmagazin.serviceImpl;

import kz.ruzgaliyev.internetmagazin.entity.Category;
import kz.ruzgaliyev.internetmagazin.entity.Product;
import kz.ruzgaliyev.internetmagazin.mapper.ProductMapper;
import kz.ruzgaliyev.internetmagazin.repository.CategoryRepository;
import kz.ruzgaliyev.internetmagazin.repository.ProductRepository;
import kz.ruzgaliyev.internetmagazin.requestDto.ProductRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.ProductResponseDto;
import kz.ruzgaliyev.internetmagazin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productMapper.toEntity(productRequestDto);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product existing = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setCategory(category);
        existing.setName(productRequestDto.getName());
        existing.setDescription(productRequestDto.getDescription());
        existing.setPrice(productRequestDto.getPrice());
        existing.setQuantity(productRequestDto.getQuantity());
        Product updatedProduct = productRepository.save(existing);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDto> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
