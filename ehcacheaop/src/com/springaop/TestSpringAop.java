package com.springaop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ehcache.PersonManagerImpl;


public class TestSpringAop {
	  public static void main(String[] args) {  
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-e.xml");  
	        PersonManagerImpl personManager = (PersonManagerImpl) context.getBean("personManager");//配置了spring就可以从配置文件里找到对应的接口实现类，再生成实例对象，以完成业务处理
	        personManager.getList("11",1);
	          
	    }  
		 
}
