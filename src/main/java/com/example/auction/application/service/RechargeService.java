package com.example.auction.application.service;

import com.example.auction.application.module.Recharge;
import com.example.auction.application.repository.RechargeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RechargeService {
    @Resource
    private RechargeRepository catRepository;
    @Resource
    private EntityManager em;

    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Recharge recharge) {
        catRepository.save(recharge);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Recharge recharge) {
        Recharge recharges = (Recharge)catRepository.findAll();
        catRepository.save(recharge);
        return "OK";
    }

    //查询数据
    @Transactional
    public Recharge findOne(Long id) {
        return (Recharge) catRepository.findOne(id);
    }

    //查询数据
    @Transactional
    public Page<Recharge> findAll(int page, int size) {
        Page<Recharge> recharge = catRepository.findAll(new PageRequest(page,size));
        return  recharge;
    }

    //查询数据,聚合userid,查询总金额
    @Transactional
    public List<Recharge> findAllByUserId(int page, int size) {
        //默认0,10传进来
        if(page == 0){
            page = 1;
        }
        int limit1 = (page-1) * size;
        int limit2 = page * size;
        List<Recharge> recharge = catRepository.findAllByUserId(limit1,limit2);
        return  recharge;
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Recharge recharge = catRepository.findOne(id);
        recharge.setIsDelete(1);
        catRepository.save(recharge);
        return "OK";
    }

}
