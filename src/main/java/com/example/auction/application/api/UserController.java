package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.User;
import com.example.auction.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

import com.dingyue.sms.client.AbsRestClient;
import com.dingyue.sms.client.JsonReqClient;
import com.dingyue.sms.client.XmlReqClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userservice;
    @Autowired
    private  HttpServletRequest request;

    @RequestMapping("indexPage")
    public String indexPage(){
        return "index.html";
    }

    @RequestMapping("getUser")
    public Page<User> getUser(@RequestBody String jsonStr){
        JSONObject object = JSONObject.parseObject(jsonStr);
        int size = Integer.parseInt(object.get("size") == null ? "10": object.get("size").toString());
        int page = Integer.parseInt(object.get("page") == null ? "0": object.get("page").toString());
        System.out.print(object.toString());
        Page<User> user = userservice.findAll(page,size);
        return user;
    }

    @RequestMapping("/getUserById")
    public User getUserById(Long userId){
        User user = userservice.findOne(userId);
        return user;
    }

    @RequestMapping(value = "saveUserById")
    public String saveUserById(@RequestBody String jsonStr){
//        String user = request.getParameter("userId");
        User user = JSONObject.parseObject(jsonStr, User.class);
        System.out.print(user.toString());
        String message = userservice.saveByUserId(user);
        return message;
    }

    @RequestMapping(value = "registerByUserId")
    public String registerByUserId(@RequestBody String jsonStr){
//        String user = request.getParameter("userId");
        User user = JSONObject.parseObject(jsonStr, User.class);
        User uuuu = userservice.findOne(user.getUserId());
        String code = uuuu.getVerificationCode();
        JSONObject object = JSONObject.parseObject(jsonStr);
        String VerificationCode = "";
        if(object.get("VerificationCode") == null){
            return "请输入验证码";
        };
        VerificationCode= object.get("VerificationCode").toString();
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object sss =request.getSession().getAttribute("VerificationCode");
//        if(request.getSession().getAttribute("VerificationCode") == null){
//            return "验证码已过期";
//        }
        //code = request.getSession().getAttribute("VerificationCode").toString();
        if(!VerificationCode.equals(code)){
            return "验证码错误";
        }
        System.out.print(user.toString());
        String message = userservice.registerByUserId(user);
        return message;
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(Long userId){
        String message = userservice.deleteOne(userId);
        return message;
    }
    @RequestMapping("/register")
    public String register(@RequestBody String jsonStr){
        User user = JSONObject.parseObject(jsonStr, User.class);
        if(user.getTelNumber() == null){
            return "请输入手机号";
        }else{
        }
        //验证码
        //String param = Double.toString (Math.random()*10000);
        Random ne = new Random();
        int i = ne.nextInt(9999-1000+1)+1000;
        String VerificationCode = Integer.toString(i);
        String accountSid="2a4ea3df0b6b94a63aa93d9ad1842eea";
        String token="3f80a7b2dbbff5c4d3e9aa9cc9fe3002";
        String appId="f9b7dac912404882935c14e919082a88";
        String templateId="185263";
        //手机号
        String to=user.getTelNumber();
        //String param="2334";
        testTemplateSMS(true, accountSid,token,appId, templateId,to,VerificationCode);//短信发送接口
        String message = userservice.VerificationCodeByUserId(user);
        return "";
    }

//    @RequestMapping(value = "registerCheck")
//    public String registerCheck(@RequestBody String jsonStr,HttpServletRequest request){
//        User user = JSONObject.parseObject(jsonStr, User.class);
//        System.out.print(user.toString());
//        String message = userservice.saveByUserId(user);
//        return message;
//    }



    static AbsRestClient InstantiationRestAPI(boolean enable) {
        if(enable) {
            return new JsonReqClient();
        } else {
            return new XmlReqClient();
        }
    }
    public void testTemplateSMS(boolean json,String accountSid,String authToken,String appId,String templateId,String to,String param){
        try {
            String result=InstantiationRestAPI(json).templateSMS(accountSid, authToken, appId, templateId, to, param);
            System.out.println("Response content is: " + result);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }



}
