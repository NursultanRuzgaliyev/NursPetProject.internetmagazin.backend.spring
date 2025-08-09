package kz.ruzgaliyev.internetmagazin.service;

import kz.ruzgaliyev.internetmagazin.entity.Product;
import kz.ruzgaliyev.internetmagazin.requestDto.ProductRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto getProductById(Long id);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);
    void deleteProduct(Long id);
    List<ProductResponseDto> searchByName(String name);
}

