package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.Temp.Cart;
import com.geekbrains.spring.web.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final Cart cart;

    public void addToCart(Long id) {
        cart.addProduct(id);
    }

    public List<Product> findAll(){
        return cart.findAll();
    }
}
