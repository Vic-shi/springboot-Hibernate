package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Auctions;
import com.example.auction.application.service.AuctionsService;
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
@RequestMapping(value = "/auctions")
public class AuctionsController {

    @Autowired
    AuctionsService auctionsService;

    @RequestMapping("getAuctions")
    public List<Auctions> getAuctions(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        List<Auctions> auctions = auctionsService.findAll(page,size);
        return auctions;
    }

    @RequestMapping("/getAuctionsById")
    public Auctions getAuctionsById(Long auctionsId){
        Auctions auctions = auctionsService.findOne(auctionsId);
        return auctions;
    }

    @RequestMapping(value = "saveAuctionsById")
    public String saveAuctionsById(@RequestBody String jsonStr){
        Auctions auctions = JSONObject.parseObject(jsonStr, Auctions.class);
        Timestamp time = new Timestamp(new Date().getTime());
        auctions.setTime(time);
        System.out.print(auctions.toString());
        String message = auctionsService.save(auctions);
        return message;
    }

    @RequestMapping("/deleteAuctionsById")
    public String deleteAuctionsById(Long auctionsId){
        String message = auctionsService.deleteOne(auctionsId);
        return message;
    }

    @RequestMapping("/findByProductId")
    public Auctions findByProductId(Long productId){
        Auctions auctions = auctionsService.findByProductId(productId);
        return auctions;
    }


}
