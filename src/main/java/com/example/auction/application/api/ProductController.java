package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Product;
import com.example.auction.application.service.ProductService;
import com.example.auction.application.util.createId.CreateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productservice;

    @RequestMapping("getProduct")
    public Page<Product> getProduct(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        Page<Product> product = productservice.findAll(page,size);
        return product;
    }



    @RequestMapping("/getProductById")
    public Product getProductById(Long productId){
        Product product = productservice.findOne(productId);
        return product;
    }

    @RequestMapping("/getProductByIdBack")
    public Product getProductByIdBack(Long productId){
        Product product = productservice.findOne(productId);
        return product;
    }

    @RequestMapping("/getProductByIsAuction")
    public Page<Product> getProductByIsAuction(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        Page<Product> product = productservice.findAllByIsAction(page,size);
        return product;
    }

    @RequestMapping(value = "saveProductById")
    public String saveProductById(@RequestBody String jsonStr){
        Product product = JSONObject.parseObject(jsonStr, Product.class);
        System.out.print(product.getProductAuthorId());
        Timestamp time = new Timestamp(new Date().getTime());
        product.setProductCreateTime(time);
        product.setProductInputTime(time);
        product.setProductUpdateTime(time);
        //System.out.println(CreateId.me.to62(9223372036854775807L)+"\n"+CreateId.me.timeTo62_fz()+"\n"+(System.nanoTime()-time1));
        String productAuthorId = product.getProductAuthorId() + CreateId.me.to62(9223372036L);
        Long productId = Long.parseLong(productAuthorId);
        System.out.print(productId);
        product.setProductId(productId);
        System.out.print(product.toString());
        String message = productservice.save(product);
        return message;
    }

    @RequestMapping("/deleteProductById")
    public String deleteProductById(Long productId){
        String message = productservice.deleteOne(productId);
        return message;
    }

    @RequestMapping("/getProductByName")
    public Page getProductByName(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        String productName = object.get("productName").toString();
        Page message = productservice.findAllByName(page,size,productName);
        return message;
    }





}
