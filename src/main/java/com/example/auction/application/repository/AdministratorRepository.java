package com.example.auction.application.repository;

import com.example.auction.application.config.CustomRepository;
import com.example.auction.application.module.Administrator;


public interface AdministratorRepository extends CustomRepository<Administrator, Long> {
    //List<Administrator> findAll(Pageable pageable);
}
