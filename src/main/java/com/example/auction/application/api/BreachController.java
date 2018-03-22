package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Breach;
import com.example.auction.application.service.BreachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/breach")
public class BreachController {

    @Autowired
    BreachService breachService;

    @RequestMapping("getBreach")
    public List<Breach> getBreach(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        List<Breach> breach = breachService.findAll(page,size);
        return breach;
    }

    @RequestMapping("/getBreachById")
    public Breach getBreachById(Long breachId){
        Breach breach = breachService.findOne(breachId);
        return breach;
    }

    @RequestMapping(value = "saveBreachById")
    public String saveBreachById(@RequestBody String jsonStr){
        Breach breach = JSONObject.parseObject(jsonStr, Breach.class);
        Timestamp time = new Timestamp(new Date().getTime());
        breach.setTime(time);
        System.out.print(breach.toString());
        String message = breachService.save(breach);
        return message;
    }

    @RequestMapping("/deleteBreachById")
    public String deleteBreachId(Long breachId){
        String message = breachService.deleteOne(breachId);
        return message;
    }

    @RequestMapping("/findAllByUserId")
    public List<Breach> findAllByUserId(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        List<Breach> recharge = breachService.findAllByUserId(page,size);
        return recharge;
    }



}
