package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Order;
import com.example.auction.application.service.OrderService;
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
import java.util.Random;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("getOrder")
    public Page<Order> getOrder(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        Page<Order> order = orderService.findAll(page,size);
        return order;
    }

    @RequestMapping("/getOrderById")
    public Order getOrderById(Long orderId){
        Order order = orderService.findOne(orderId);
        return order;
    }

    @RequestMapping("/getOrderByUserId")
    public Page<Order> getOrderByUserId(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        Long userId = Long.parseLong(object.get("userId").toString());
        System.out.print(object.toString());
        Page<Order> order = orderService.findByUserId(page,size,userId);
        return order;
    }



    @RequestMapping(value = "saveOrderById")
    public String saveOrderById(@RequestBody String jsonStr){
        Order order = JSONObject.parseObject(jsonStr, Order.class);
        Timestamp time = new Timestamp(new Date().getTime());
        order.setOrderCreateTime(time);
        Random ne = new Random();
        int orderId = ne.nextInt(99999999-10000000+1)+10000000;
        String ss = order.getUserId() + String.valueOf(orderId);
        //String orderId = userId + CreateId.me.to62(9223372036L);
        Long orderIds= Long.parseLong(ss);
        order.setOrderId(orderIds);
        System.out.print(order.toString());
        String message = orderService.save(order);
        return message;
    }

    @RequestMapping("/deleteOrderById")
    public String deleteOrderById(Long orderId){
        String message = orderService.deleteOne(orderId);
        return message;
    }




}
