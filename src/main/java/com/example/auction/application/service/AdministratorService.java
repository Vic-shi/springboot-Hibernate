package com.example.auction.application.service;

import com.example.auction.application.module.Administrator;
import com.example.auction.application.repository.AdministratorRepository;
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
public class AdministratorService {
    @Resource
    private AdministratorRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Administrator administrator) {
        catRepository.save(administrator);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Administrator administrator) {
        Administrator administrators = (Administrator)catRepository.findAll();
        catRepository.save(administrator);
        return "OK";
    }

    //查询数据
    @Transactional
    public Administrator findOne(Long id) {
        return (Administrator) catRepository.findOne(id);
    }

    //查询数据
    @Transactional
    public Page<Administrator> findAll(int page, int size) {
        Page<Administrator> administrator = catRepository.findAll(new PageRequest(page,size));
        return administrator;
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Administrator administrators = catRepository.findOne(id);
        administrators.setIsDelete(1);
        catRepository.save(administrators);
        return "OK";
    }

    //管理员登录
    @Transactional
    public String login(String adminName,String password) {
        Specification<Administrator> spec = new Specification<Administrator>() {
            @Override
            public Predicate toPredicate(Root<Administrator> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate adminNames = criteriaBuilder.equal(root.get("adminName"),adminName);
                return criteriaBuilder.and(adminNames);
            }
        };
        List<Administrator> orgs = catRepository.findAll(spec);
        if(orgs.size() == 0){
            return "该管理员不存在!";
        }
        String passwords =  orgs.get(0).getPassword();
        if(password.equals(passwords)){
            String  boomBoomId= String.valueOf(System.currentTimeMillis());
            return boomBoomId;
        }else{
            return "管理员密码错误";
        }
    }

}
