package com.example.auction.application.service;

import com.example.auction.application.module.Author;
import com.example.auction.application.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {
    @Resource
    private AuthorRepository catRepository;
    /**
     * save,update,delete方法需要绑定事物
     * 使用@Transactional进行事物绑定
     */
    //保存数据
    @Transactional
    public String save(Author author) {
        catRepository.save(author);
        return "OK";
    }
    //更新数据
    @Transactional
    public String update(Author author) {
        Author authors = (Author)catRepository.findAll();
        catRepository.save(author);
        return "OK";
    }

    //查询数据
    @Transactional
    public Author findOne(Long id) {
        return (Author) catRepository.findOne(id);
    }

    //查询数据
    @Transactional
    public List<Author> findAll(int page, int size) {
        List<Author> author = catRepository.findAll(new PageRequest(page,size));
        return author;
    }

    //删除数据
    @Transactional
    public String deleteOne(Long id) {
        Author author = catRepository.findOne(id);
        author.setIsDelete(1);
        catRepository.save(author);
        return "OK";
    }

}
