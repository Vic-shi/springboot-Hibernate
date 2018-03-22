package com.example.auction.application.service;

import com.example.auction.application.module.Breach;
import com.example.auction.application.repository.BreachRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BreachService {
    @Resource
    private BreachRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Breach breach) {
        catRepository.save(breach);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Breach breach) {
        Breach recharges = (Breach)catRepository.findAll();
        catRepository.save(breach);
        return "OK";
    }

    //查询数据
    @Transactional
    public Breach findOne(Long id) {
        return (Breach) catRepository.findOne(id);
    }

    //查询数据
    @Transactional
    public List<Breach> findAll(int page,int size) {
        List<Breach> breach = catRepository.findAll(new PageRequest(page,size));
        return breach;
    }

    //查询数据,聚合userid,查询总金额
    @Transactional
    public List<Breach> findAllByUserId(int page, int size) {
        //默认0,10传进来
        if(page == 0){
            page = 1;
        }
        int limit1 = (page-1) * size;
        int limit2 = page * size;
        List<Breach> recharge = catRepository.findAllByUserId(limit1,limit2);
        return  recharge;
    }


    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Breach recharge = catRepository.findOne(id);
        recharge.setIsDelete(1);
        catRepository.save(recharge);
        return "OK";
    }

}
