package com.example.auction.application.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
* 支付流程验证
* @author ctl
* @version 创建时间：2017年11月30日 下午1:16:10
*/
public class PayMent {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 支付金额与订单金额是否一致(包括退款)
	 * @param oldfee 订单金额, newfee 支付金额(退款金额)
	 * @return  
	 */
	public  static Map<String,Map<String,String>> totalFeeResult(String oldfee,String newfee){
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		Map<String,String> smap =new HashMap<String,String>();
		String state = "0";
		String msg = "Incoming parameter is empty-----传入参数为空";
		smap.put(state, msg);
		map.put("msg", smap);
		System.out.println();
		if(oldfee == null || oldfee.length() == 0 || 
				newfee == null || newfee.length() == 0 ){
			return map;
		}
		if(oldfee.equals("newfee")){
			state = "999";
			msg = "The same amount of verification-----金额验证一致";
			smap =new HashMap<String,String>(); 
			smap.put(state, msg);
			map.put("msg", smap);
		}
		return map;
	}
	
	public static String getopenid(HttpServletRequest request){
		String openid = request.getParameter("open_id");
		Cookie[] cookies = request.getCookies();
		if(openid==null || openid=="" ||openid.equals("")){
			openid = (String) request.getSession().getAttribute("open_id");
			System.out.println("Session中获取openid："+openid);
		}
		if(openid==null || openid=="" ||openid.equals("")){
			if(!isEmpty(cookies)){
				for(Cookie cookie : cookies){
					String name = cookie.getName();
				    if(name.contains("open_id")){
				    	openid = cookie.getValue();
				    }
				}
			}
		}
//		if(openid == null || openid=="" ||openid.equals("")){
//			System.out.println(redis.get("open_id"));
//			if(redis.get("open_id")!=null){
//				openid =redis.get("open_id");
//			}
//		}
		return openid;
	}
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		}
		if (obj instanceof String) {
			if ("NULL".equals(obj.toString().trim().toUpperCase())
					|| "".equals(obj.toString().trim())) {
				return true;
			} else {
				return false;
			}
		} else if (obj instanceof Collection) {
			return ((Collection<?>) obj).size() == 0;
		} else if (obj instanceof Map) {
			return ((Map<?, ?>) obj).size() == 0;
		} else if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		} else {
			return false;
		}
	}
	
}
