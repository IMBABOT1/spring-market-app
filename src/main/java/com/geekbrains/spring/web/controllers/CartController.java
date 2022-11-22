package com.geekbrains.spring.web.controllers;


import com.geekbrains.spring.web.converters.ProductConverter;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        List<ProductDto> productDto = new ArrayList<>();
        for (Product p : cartService.findAll()){
            productDto.add(productConverter.entityToDto(p));
        }
        return productDto;
    }

    @GetMapping("/add/{id}")
    public void getProductById(@PathVariable Long id) {
        cartService.addToCart(id);
    }
}
