package com.vektorel.redisdersleri.service;

import com.vektorel.redisdersleri.dto.ProductResponseDto;
import com.vektorel.redisdersleri.dto.ProductSaveAllRequestDto;
import com.vektorel.redisdersleri.dto.ProductSaveRequestDto;
import com.vektorel.redisdersleri.entity.Product;
import com.vektorel.redisdersleri.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;


    @CacheEvict(value = "products", allEntries = true)
    public void saveProduct(ProductSaveRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        repository.save(product);
        //redisService.silAllProducts();
    }

    @CacheEvict(value = "products", allEntries = true)
    public void saveAllProducts(ProductSaveAllRequestDto dtos) {
        List<Product> products = new ArrayList<>();

        for (ProductSaveRequestDto dto : dtos.getDtos()) {
            Product product = new Product();
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setStock(dto.getStock());
            products.add(product);
        }

        repository.saveAll(products);
    }


    @Cacheable(value = "products")
    public List<ProductResponseDto> getAllProducts() {
        //redisService.getAllProducts();
        List<Product> products = repository.findAll();

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for (Product product : products) {

            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setId(product.getId());
            productResponseDto.setName(product.getName());
            productResponseDto.setDescription(product.getDescription());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setStock(product.getStock());

            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }

}
