package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Administrator;
import com.example.auction.application.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/administrator")
public class AdministratorController {

    @Autowired
    @Resource
    AdministratorService adminstratorService;

    @RequestMapping("getAdministrator")
    public Page<Administrator> getAdministrator(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        Page<Administrator> administrator = adminstratorService.findAll(page,size);
        return administrator;
    }

    @RequestMapping("/getAdministratorById")
    public Administrator getAdministratorById(Long administratorId){
        Administrator administrator = adminstratorService.findOne(administratorId);
        return administrator;
    }

    @RequestMapping(value = "saveAdministratorById")
    public String saveAdministratorById(@RequestBody String jsonStr){
//        String user = request.getParameter("userId");
        Administrator administrator = JSONObject.parseObject(jsonStr, Administrator.class);
       // IdUtil ID = IdUtil.getInstance();
        System.out.print(administrator.toString());
        String message = adminstratorService.save(administrator);
        return message;
    }

    @RequestMapping("/deleteAdministratorById")
    public String deleteAdministratorId(Long administratorId){
        String message = adminstratorService.deleteOne(administratorId);
        return message;
    }




}
