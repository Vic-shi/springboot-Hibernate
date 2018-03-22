package com.example.auction.application.service;

import com.example.auction.application.module.User;
import com.example.auction.application.repository.UserRepository;
import org.springframework.data.domain.Page;
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
public class UserService {
    @Resource
    private UserRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(User user) {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate openid = criteriaBuilder.equal(root.get("openId"),user.getOpenId());
                return criteriaBuilder.and(openid);
            }
        };
        List<User> orgs = catRepository.findAll(spec);
        System.out.print(orgs);
        if(orgs.size() >= 1){
            String mmm = orgs.get(0).getUserId().toString();
            return orgs.get(0).getUserId().toString();
        }else{
            /*
             *  新增用户
             */
            User users = catRepository.save(user);
            return user.getUserId().toString();
        }

    }
    //保存数据
    @Transactional
    public String saveByUserId(User user) {
        User users = catRepository.findOne(user.getUserId());
        users.setHeadimgUrl(user.getHeadimgUrl());
        users.setCity(user.getCity());
        users.setCountry(user.getCountry());
        users.setLanguage(user.getLanguage());
        users.setNickName(user.getNickName());
        users.setProvince(user.getProvince());
        catRepository.save(users);
        return "OK";
    }

    //保存手机号
    @Transactional
    public String registerByUserId(User user) {
        User users = catRepository.findOne(user.getUserId());
        users.setTelNumber(user.getTelNumber());
        catRepository.save(users);
        return "OK";
    }

    //保存验证码
    @Transactional
    public String VerificationCodeByUserId(User user) {
        User users = catRepository.findOne(user.getUserId());
        users.setVerificationCode(user.getVerificationCode());
        catRepository.save(users);
        return "OK";
    }
    //查询数据
    @Transactional
    public User findOne(Long id) {
        return (User) catRepository.findOne(id);
    }

    //查询数据
    @Transactional
    public Page<User> findAll(int page, int size) {
        Page<User> users = catRepository.findAll(new PageRequest(page,size));
        //Page<User> users = repository.findAll(new PageRequest(1, 20));
        return users;
        //return (List<User>) catRepository.findAll();
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        User user = catRepository.findOne(id);
        user.setIsDelete(1);
        catRepository.save(user);
        return "OK";
    }
}
