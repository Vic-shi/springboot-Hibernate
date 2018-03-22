package com.example.auction.application.service;

import com.example.auction.application.module.Order;
import com.example.auction.application.repository.OrderRepository;
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
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Order order) {
        catRepository.save(order);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Order order) {
        Order orders = (Order)catRepository.findAll();
        catRepository.save(order);
        return "OK";
    }

    //查询一个数据
    @Transactional
    public Order findOne(Long id) {
        return (Order) catRepository.findOne(id);
    }

    //查询一个用户的订单
    @Transactional
    public Page<Order> findByUserId(int page,int size,Long userId) {
        Specification<Order> spec = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate userIds = criteriaBuilder.equal(root.get("userId"),userId);
                return criteriaBuilder.and(userIds);
            }
        };
        Pageable pageable = new PageRequest(page,size);
        Page<Order> orgs = catRepository.findAll(spec,pageable);
        return orgs;
    }

    //查询所有数据
    @Transactional
    public Page<Order> findAll(int page,int size) {
        Page<Order> order = catRepository.findAll(new PageRequest(page,size));
        return order;
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Order order = catRepository.findOne(id);
        order.setIsDelete(1);
        catRepository.save(order);
        return "OK";
    }

}
