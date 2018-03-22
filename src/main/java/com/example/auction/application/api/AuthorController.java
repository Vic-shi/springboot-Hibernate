package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Author;
import com.example.auction.application.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("getAuthor")
    public List<Author> getAuthor(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        List<Author> author = authorService.findAll(page,size);
        return author;
    }

    @RequestMapping("/getAuthorById")
    public Author getAuthorById(Long authorId){
        Author author = authorService.findOne(authorId);
        return author;
    }

    @RequestMapping(value = "saveAuthorById")
    public String saveAuthorById(@RequestBody String jsonStr){
//        String user = request.getParameter("userId");
        Author author = JSONObject.parseObject(jsonStr, Author.class);
       // IdUtil ID = IdUtil.getInstance();
        System.out.print(author.toString());
        String message = authorService.save(author);
        return message;
    }

    @RequestMapping("/deleteAuthorById")
    public String deleteAuthoryId(Long authorId){
        String message = authorService.deleteOne(authorId);
        return message;
    }




}
