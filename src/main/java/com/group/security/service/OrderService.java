package com.group.security.service;

import com.group.security.entity.Order;
import com.group.security.entity.UserInfo;
import com.group.security.repository.OrderRepository;
import com.group.security.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserInfoRepository userInfoRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public UserInfo findUserInfoById(Integer userId) {
        return userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
