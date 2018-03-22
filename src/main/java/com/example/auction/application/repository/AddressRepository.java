package com.example.auction.application.repository;

import com.example.auction.application.module.Address;
import com.example.auction.application.module.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long>{
    List<Address> findAll(Pageable pageable);
}
