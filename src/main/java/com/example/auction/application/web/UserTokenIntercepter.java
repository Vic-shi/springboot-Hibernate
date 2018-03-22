package com.example.auction.application.web;


//import com.example.auction.util.PayMent;
import com.google.gson.Gson;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//import com.dingyue.service.payment.commons.util.PayMent;
//import com.google.gson.Gson;

//import me.chanjar.weixin.mp.api.WxMpService;


/**
* 跳转拦截器
* @author ctl
*/
public class UserTokenIntercepter extends HandlerInterceptorAdapter{

    protected Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    protected WxMpService weixinService;
    
    
    /**
     * 拦截openid为空的用户，开放第一次token服务器验证请求
     * @return boolean
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
		String servletPath = request.getServletPath().toString();
		log.debug("---------------firsturl:"+servletPath);
		//设置根目录下的首页访问
		if(servletPath.length()<7){
			response.sendRedirect(request.getScheme()+"://"+ request.getServerName()+request.getContextPath()+"/index.jsp");
			return true;
		}
		String url = servletPath.substring(0,7);
		String path=request.getScheme()+"://"+ request.getServerName();
		log.debug("---------------lasturl:"+url);
		System.out.println("协议名：//域名="+path);
		System.out.println("---------------"+url);
		Cookie[] cookies = request.getCookies();
		String code = request.getParameter("code");
		String openid = request.getParameter("open_id");
		if(openid==null || openid=="" ||openid.equals("")){
			log.debug("request.getParameter open_id is null");
			openid = (String) request.getSession().getAttribute("open_id");
			System.out.println("Session中获取openid："+openid);
		}
		if(openid==null || openid=="" ||openid.equals("")){
//			if(!PayMent.isEmpty(cookies)){
				for(Cookie cookie : cookies){
					String name = cookie.getName();
				    if(name.contains("open_id")){
				    	log.debug("request.getAttribute open_id is null");
				    	openid = cookie.getValue();
				    }
				}
//			}
		}
		if(openid == null || openid=="" ||openid.equals("")){
			if(code!=null){
				return true;
			}
			log.debug("openid&&&code is null");
			log.debug("ServletPath>>>url" + servletPath);
			System.out.println("openid&&&code---------------"+url);
			
			if(url.equals("/client")&&!servletPath.equals("/client/testservice/token")){
				System.out.println(path+request.getContextPath()+"/client/OAuth/userinfourl=" + servletPath);
				/*if(request.getSession().getAttribute("Rurl")==null){
					System.out.println("Rurl---------"+servletPath);
					request.getSession().setAttribute("Rurl", servletPath);
				}*/
//				request.getRequestDispatcher(weixinService.oauth2buildAuthorizationUrl(path+request.getContextPath()+"/client/OAuth/userinfo?url=" + servletPath, "snsapi_userinfo", "STATE")).forward(request, response);
//				response.sendRedirect(weixinService.oauth2buildAuthorizationUrl(path+request.getContextPath()+"/client/OAuth/userinfo?url=" + servletPath, "snsapi_userinfo", "STATE"));
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { // 如果是ajax请求响应头会有x-requested-with
					Gson gson=new Gson();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("rs_code",1005);
					response.getWriter().write(gson.toJson(map));
				}else {
					//response.sendRedirect(weixinService.oauth2buildAuthorizationUrl(path+request.getContextPath()+"/client/OAuth/userinfo?url=" + servletPath, "snsapi_userinfo", "STATE"));
					response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+weixinService.getWxMpConfigStorage().getAppId()+"&redirect_uri="+ path+request.getContextPath()+"/client/OAuth/userinfo?url="
							+ servletPath
							+ "&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect");
					System.out.println("res-----url---:"+"https://open.weixin.qq.com/connect/oauth2/authorize?appid="+weixinService.getWxMpConfigStorage().getAppId()+"&redirect_uri="+ path+request.getContextPath()+"/client/OAuth/userinfo?url="+ servletPath+ "&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect");
				}
				return true;
			}else{
				return true;
			}
		}else{
			if(request.getSession().getAttribute("open_id")==null){
				request.getSession().setAttribute("open_id",openid);
			}
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	

}
