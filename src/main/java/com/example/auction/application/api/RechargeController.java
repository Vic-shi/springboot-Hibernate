package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Recharge;
import com.example.auction.application.service.RechargeService;
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
@RequestMapping(value = "/recharge")
public class RechargeController {

    @Autowired
    RechargeService rechargeService;

    @RequestMapping("getRecharge")
    public Page<Recharge> getRecharge(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        Page<Recharge> recharge = rechargeService.findAll(page,size);
        return recharge;
    }

    @RequestMapping("/getRechargeById")
    public Recharge getRechargeById(Long rechargeId){
        Recharge recharge = rechargeService.findOne(rechargeId);
        return recharge;
    }

    @RequestMapping(value = "saveRechargeById")
    public String saveRechargeById(@RequestBody String jsonStr){
//        String user = request.getParameter("userId");
        Recharge recharge = JSONObject.parseObject(jsonStr, Recharge.class);
       // IdUtil ID = IdUtil.getInstance();
        Timestamp time = new Timestamp(new Date().getTime());
        recharge.setTime(time);
        System.out.print(recharge.toString());
        String message = rechargeService.save(recharge);
        return message;
    }

    @RequestMapping("/deleteRechargeById")
    public String deleteRechargeId(Long rechargeId){
        String message = rechargeService.deleteOne(rechargeId);
        return message;
    }

    @RequestMapping("/findAllByUserId")
    public List<Recharge> findAllByUserId(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        List<Recharge> recharge = rechargeService.findAllByUserId(page,size);
        return recharge;
    }


}
