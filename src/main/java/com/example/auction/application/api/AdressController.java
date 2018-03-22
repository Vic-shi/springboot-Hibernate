package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Address;
import com.example.auction.application.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AdressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("getAddress")
    public List<Address> getAddress(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        List<Address> address = addressService.findAll(page,size);
        return address;
    }

    @RequestMapping("/getAddressById")
    public Address getAddressById(Long addressId){
        Address address = addressService.findOne(addressId);
        return address;
    }

    @RequestMapping(value = "saveAddressById")
    public String saveAddressById(@RequestBody String jsonStr){
//        String user = request.getParameter("userId");
        Address address = JSONObject.parseObject(jsonStr, Address.class);
       // IdUtil ID = IdUtil.getInstance();
        System.out.print(address.toString());
        String message = addressService.save(address);
        return message;
    }

    @RequestMapping("/deleteAddressById")
    public String deleteAddressId(Long addressId){
        String message = addressService.deleteOne(addressId);
        return message;
    }




}
