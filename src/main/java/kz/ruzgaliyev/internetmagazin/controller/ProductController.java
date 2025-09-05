package kz.ruzgaliyev.internetmagazin.controller;

import kz.ruzgaliyev.internetmagazin.entity.Product;
import kz.ruzgaliyev.internetmagazin.requestDto.ProductRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.ProductResponseDto;
import kz.ruzgaliyev.internetmagazin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return ResponseEntity.ok(productService.createProduct(productRequestDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable  Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @GetMapping()
    public ResponseEntity<ProductResponseDto> getAllProducts(){
        return ResponseEntity.ok((ProductResponseDto) productService.getAllProducts());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updatedProduct(@PathVariable Long id,@RequestBody ProductRequestDto productRequestDto ){
        return ResponseEntity.ok(productService.updateProduct(id, productRequestDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDto>> search(@RequestParam String name){
        return ResponseEntity.ok(productService.searchByName(name));
    }
}
