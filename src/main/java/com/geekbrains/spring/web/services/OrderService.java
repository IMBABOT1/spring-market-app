package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.entities.Order;
import com.geekbrains.spring.web.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

}
