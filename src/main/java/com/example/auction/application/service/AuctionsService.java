package com.example.auction.application.service;

import com.example.auction.application.module.Auctions;
import com.example.auction.application.repository.AuctionsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
public class AuctionsService {
    @Resource
    private AuctionsRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Auctions auctions) {
        catRepository.save(auctions);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Auctions recharge) {
        Auctions auctions = (Auctions)catRepository.findAll();
        catRepository.save(auctions);
        return "OK";
    }

    //查询数据
    @Transactional
    public Auctions findOne(Long id) {
        return (Auctions) catRepository.findOne(id);
    }

    //查询数据
    @Transactional
    public Auctions findByProductId(Long productId) {
        Sort sort = new Sort(Sort.Direction.DESC,"money");
        Specification<Auctions> spec = new Specification<Auctions>() {
            @Override
            public Predicate toPredicate(Root<Auctions> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate productIds = criteriaBuilder.equal(root.get("productId"),productId);
                return criteriaBuilder.and(productIds);
            }
        };
        List<Auctions> auctions = catRepository.findAll(spec,sort);

        if(auctions.size() == 0){
            return new Auctions();
        }
        return auctions.get(0);
    }
    //查询数据
    @Transactional
    public List<Auctions> findAll(int page,int size) {
        Sort sort = new Sort(Sort.Direction.DESC,"money");
        List<Auctions> auctions = catRepository.findAll(sort);
        return auctions;
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Auctions auctions = catRepository.findOne(id);
        auctions.setIsDelete(1);
        catRepository.save(auctions);
        return "OK";
    }

}
