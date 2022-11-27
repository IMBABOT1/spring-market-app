package com.geekbrains.spring.web.controllers;


import com.geekbrains.spring.web.dto.Cart;
import com.geekbrains.spring.web.entities.Order;
import com.geekbrains.spring.web.entities.OrderItem;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.services.OrderService;
import com.geekbrains.spring.web.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
    public void saveOrder(Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        OrderItem orderItem = new OrderItem();
        Order order = new Order(null, user.get(), orderItem.getOrder().getItems(), 20, "address", "phone");
        orderService.save(order);
    }

}
