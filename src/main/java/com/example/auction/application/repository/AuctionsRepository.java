package com.example.auction.application.repository;

import com.example.auction.application.config.CustomRepository;
import com.example.auction.application.module.Auctions;
import com.example.auction.application.module.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuctionsRepository extends CustomRepository<Auctions, Long> {
    //List<Auctions> findAll(Pageable pageable);
}
