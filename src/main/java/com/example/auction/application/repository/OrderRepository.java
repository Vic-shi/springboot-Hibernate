package com.example.auction.application.repository;

import com.example.auction.application.config.CustomRepository;
import com.example.auction.application.module.Order;


public interface OrderRepository extends CustomRepository<Order, Long> {
    //List<Order> findAll(Pageable pageable);
}
