package com.example.auction;

import com.example.auction.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@SpringBootApplication
@EnableScheduling
public class AuctionApplication {

	@Autowired
	ProductService productservice;

	public static void main(String[] args) {
		SpringApplication.run(AuctionApplication.class, args);
	}


	/*
	*拦截器
	 */
	@Configuration
	static class WebMvcConfigurer extends WebMvcConfigurerAdapter {
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new HandlerInterceptorAdapter() {
				@Override
				public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
										 Object handler) throws Exception {
					request.getContextPath();
					System.out.println("interceptor====");
					String url = request.getServletPath().toString();
					Object boomBoomId = request.getSession().getAttribute("boomBoomId");
//					if(url.equals("/administrator/getAdministratorById")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/recharge/getRecharge")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/recharge/getRechargeById")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/user/getUser")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/order/getOrder")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/product/getProductByName")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/product/saveProductById")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/product/getProductById")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
//					if(url.equals("/product/getProduct")){
//						if(request.getSession().getAttribute("boomBoomId") == null){
//							response.sendRedirect("index.html");
//						}
//					}
					return true;
				}
			}).addPathPatterns("/**");
		}
	}


}

