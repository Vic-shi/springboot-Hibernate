package com.example.auction.application.api;

import com.alibaba.fastjson.JSONObject;
import com.example.auction.application.module.User;
import com.example.auction.application.service.AdministratorService;
import com.example.auction.application.service.UserService;
import com.example.auction.application.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UserService userservice;

    @Autowired
    AdministratorService adminstratorService;

    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public String login(String code, HttpServletRequest request, HttpServletResponse response){
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String charset = "utf-8";
        HttpsURLConnection connect = null;
        //String code1 = request.getParameter("code");
        //       // System.out.println(code1);
            try{
                System.out.println(code);
                /*WX_URL:获取opneid*/
                String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=wx65c1ba6aa3caa056&secret=784bec2cc77de04a95955cc9ce0942ed&js_code="+code+"&grant_type=authorization_code";
                System.out.println(WX_URL);
                Map<String,String> createMap = new HashMap<String,String>();
                createMap.put("openid","*****");
                String httpOrgCreateTestRtn = httpClientUtil.doPost(WX_URL,createMap,charset);
                System.out.println("result:"+httpOrgCreateTestRtn);
                JSONObject object = JSONObject.parseObject(httpOrgCreateTestRtn);
                String openid = object.get("openid").toString();
                System.out.print(openid);
                User user = new User();
                user.setOpenId(openid);
                String message = userservice.save(user);
                return message;
            }catch(Exception e){
                //Todo
                return "";
    }
    }
    @RequestMapping("/loginAdministrator")
    public String loginAdministrator(@RequestBody String jsonStr,HttpServletRequest request){
        JSONObject object = JSONObject.parseObject(jsonStr);
        String adminName = object.get("adminName").toString();
        String password = object.get("password").toString();
        String message = adminstratorService.login(adminName,password);
        request.getSession().setAttribute("boomBoomId",message);
        return message;
    }



}
