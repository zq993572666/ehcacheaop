package com.ehcache;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dou.book.data.pojo.SBook;
import com.dou.book.data.services.impl.SBookServices;

public class HelloEhcacheSpring {
	  public static void main(String[] args) {  
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-e.xml");  
	          
	        PersonManagerImpl personManager = (PersonManagerImpl) context.getBean("personManager");//配置了spring就可以从配置文件里找到对应的接口实现类，再生成实例对象，以完成业务处理  
	          
	            showPersonsInfo(personManager);  
	       
	        System.out.println("-------------------------------------------");
	        showPersonsInfo(personManager); 
	   /*     for(int i=0;i<5;i++) {  
	            showPersonsInfo(personManager);  
	        }  */
	    }  
	    private static void showPersonsInfo(PersonManagerImpl personManager) {  
	        //要是没有cache时，那么这里会直接从PersonmanagerImpl类的实例对象获取到数据，这里配置了cache后，就会先跳到cache去更新cache，再往下执行  
	        List<String> persons = personManager.getList("str",1);  
	          
	        for(String person : persons) {  
	            System.out.println(person);  
	        }  
	    }
		 
}
