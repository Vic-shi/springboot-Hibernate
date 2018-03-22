package com.example.auction.application.service;

import com.example.auction.application.module.Address;
import com.example.auction.application.repository.AddressRepository;
import org.springframework.data.domain.PageRequest;
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
public class AddressService {
    @Resource
    private AddressRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Address address) {
        catRepository.save(address);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Address address) {
        Address addresss = (Address)catRepository.findAll();
        catRepository.save(address);
        return "OK";
    }

    //查询数据
    @Transactional
    public Address findOne(Long id) {
        return (Address) catRepository.findOne(id);
    }

    //查询数据
    @Transactional
    public List<Address> findAll(int page,int size) {
        List<Address> address = catRepository.findAll(new PageRequest(page,size));
        Specification<Address> spec = new Specification<Address>() {
            @Override
            public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
        catRepository.findAll();
        return address;
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Address address = catRepository.findOne(id);
        address.setSfdelete(1);
        catRepository.save(address);
        return "OK";
    }

}
