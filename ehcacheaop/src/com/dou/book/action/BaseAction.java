package com.dou.book.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.dou.book.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,RequestAware,ServletResponseAware {
private HttpServletRequest httpServletRequest;
private HttpServletResponse response;
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		// TODO Auto-generated method stub
		httpServletRequest=servletRequest;
		
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		this.response=httpServletResponse;
	}
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
public void objectToJsonString(Object object){
	 	response.setCharacterEncoding("UTF-8"); 
	   response.setContentType("application/json");  
	    try {
			String jsonString=JsonUtil.objectToJson(object);
			response.getWriter().print(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
