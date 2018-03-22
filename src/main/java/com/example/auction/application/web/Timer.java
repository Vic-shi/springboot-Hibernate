package com.example.auction.application.web;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.Auctions;
import com.example.auction.application.module.Order;
import com.example.auction.application.module.Product;
import com.example.auction.application.repository.ProductRepository;
import com.example.auction.application.service.AuctionsService;
import com.example.auction.application.service.OrderService;
import com.example.auction.application.service.ProductService;
import com.example.auction.application.util.createId.CreateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class Timer {
    @Autowired
    ProductService productservice;
    @Autowired
    AuctionsService auctionsService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductRepository productRepository;
    /*
     *定时器
     */
    //@Scheduled(cron = "* 5/5 * * * ? ")
    public void timer(){
        //扫描数据库
        Page<Product> pages =  productservice.findAllByIsAction(0,1000);
        //当前时间的毫秒数
        long nowTime = System.currentTimeMillis();
        for(int i=0;i<pages.getContent().size();i++){
            Date EndTime= pages.getContent().get(i).getProductEndTime();
            Long EndTimes = EndTime.getTime();
            //当前时间大于拍卖结束时间,开始结单
            if(nowTime>EndTimes){
                //将作品的是否拍卖改成0
                //查询拍卖表,是否有该作品ID的用户,没有将作品is_delete属性改成1,有就生成订单,绑定用户ID
                Long productId = pages.getContent().get(i).getProductId();
                Auctions auctions = auctionsService.findByProductId(productId);
                if(auctions.getAuctionId() == null){
                    //空的,删除作品
                    String message = productservice.deleteOne(productId);
                }else{
                    //有用户,开始新增订单,绑定该用户id
                    //用户id,最高金额
                    Long userId = auctions.getUserId();
                    Long money =  auctions.getMoney();
                    String nickName = auctions.getNickName();
                    String telNumber = auctions.getTelNumber();
                    Order order = new Order();
                    Timestamp time = new Timestamp(new Date().getTime());
                    //生成订单id
                    Random ne = new Random();
                    int orderId = ne.nextInt(99999999-10000000+1)+10000000;
                    String ss = userId + String.valueOf(orderId);
                    //String orderId = userId + CreateId.me.to62(9223372036L);
                    Long orderIds= Long.parseLong(ss);
                    System.out.print(orderIds);
                    //订单生成时间,订单id,作品id,订单金额,用户id,用户名称,作品名称
                    order.setOrderCreateTime(time);
                    order.setOrderId(orderIds);
                    order.setProductId(productId);
                    order.setActualPayment(money);
                    order.setUserId(userId);
                    order.setTelNumber(telNumber);
                    order.setNickName(nickName);
                    order.setProductName(pages.getContent().get(0).getProductName());
                    System.out.print(order.toString());
                    String message = orderService.save(order);
                    productRepository.delete(productId);
                }
            }
        }
//        int i = 0;
//        i++;
//        //String orderId = userId + CreateId.me.to62(9223372036L);
//        Set set = new HashSet();
//        for(int t = 0;t<100;t++){
//            Random ne = new Random();
//            int orderId = ne.nextInt(99999999-10000000+1)+10000000;
//            String ss = 12 + String.valueOf(orderId);
//            set.add(ss);
//            if(i>set.size()){
//                System.out.println("重复");
//            }
//            System.out.println(ss.toString());
//        }
//        Long orderIds= Long.parseLong(ss);
//        System.out.print(orderIds);

    }




}
