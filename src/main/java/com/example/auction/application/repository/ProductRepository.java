package com.example.auction.application.repository;

import com.example.auction.application.config.CustomRepository;
import com.example.auction.application.module.Product;
import com.example.auction.application.module.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CustomRepository<Product,Long>{
    //List<Product> findAll(Pageable pageable);
}
