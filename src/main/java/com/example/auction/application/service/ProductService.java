package com.example.auction.application.service;

import com.example.auction.application.config.CustomRepository;
import com.example.auction.application.module.Product;
import com.example.auction.application.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Resource
    private ProductRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Product product) {
        catRepository.save(product);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Product product) {
        Product Products = (Product)catRepository.findAll();
        catRepository.save(product);
        return "OK";
    }

    //单个作品查询
    @Transactional
    public Product findOne(Long id) {
        return (Product) catRepository.findOne(id);
    }

    //所有作品查询
    @Transactional
    public Page<Product> findAll(int page,int size) {
        //List<Product> product = catRepository.findAll(new PageRequest(page,size));
        Page pages =  catRepository.findAll(new PageRequest(page,size));
        return pages;
    }

    //拍卖作品分页查询
    @Transactional
    public Page<Product> findAllByIsAction(int page,int size) {
        Specification<Product> spec = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate isAuctions = criteriaBuilder.equal(root.get("isAuction"),1);
                return criteriaBuilder.and(isAuctions);
            }
        };
        Pageable pageable = new PageRequest(page,size);
        Page<Product> pages =  catRepository.findAll(spec,pageable);
        return pages;
    }

    //作品名称模糊查询
    @Transactional
    public Page<Product> findAllByName(int page,int size,String productName) {
        Specification<Product> spec = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate productNames = criteriaBuilder.like(root.get("productName"),"%"+productName+"%");
                return criteriaBuilder.and(productNames);
            }
        };
        Pageable pageable = new PageRequest(page,size);
        Page<Product> pages =  catRepository.findAll(spec,pageable);
        return pages;
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Product product = catRepository.findOne(id);
        product.setIsAuction(0);
        product.setIsDelete(1);
        catRepository.save(product);
        return "OK";
    }

}
