package com.example.auction.application.repository;

import com.example.auction.application.module.Author;
import com.example.auction.application.module.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    List<Author> findAll(Pageable pageable);
}
