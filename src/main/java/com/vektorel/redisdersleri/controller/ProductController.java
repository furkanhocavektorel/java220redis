package com.vektorel.redisdersleri.controller;

import com.vektorel.redisdersleri.dto.ProductResponseDto;
import com.vektorel.redisdersleri.dto.ProductSaveAllRequestDto;
import com.vektorel.redisdersleri.dto.ProductSaveRequestDto;
import com.vektorel.redisdersleri.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("product")
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public void save(@RequestBody ProductSaveRequestDto dto){
        productService.saveProduct(dto);
    }

    @PostMapping("/save-all")
    public void save(@RequestBody ProductSaveAllRequestDto dtos){
        productService.saveAllProducts(dtos);
    }

    @GetMapping("/get-all")
    public List<ProductResponseDto> getAll(){
        return productService.getAllProducts();
    }


}
