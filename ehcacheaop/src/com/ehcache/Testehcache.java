package com.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testehcache {
	private  CacheManager cacheManager;
	
	  public static void main(String[] args) {  
		  Testehcache testehcache=new Testehcache();
		  testehcache.test();
	    	
	    }  
	  public void test(){
		  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-e.xml");  
	    	 EhCacheCacheManager methodCache=(EhCacheCacheManager) context.getBean("methodCache");
	    	 cacheManager=methodCache.getCacheManager();
	    	 echecha();
	    	 System.out.println("----------");
	    	 echecha();
		  
	  }
	  public void echecha(){
		  
		  Cache cache= cacheManager.getCache("test111");
	    	 if(cache==null){
	    			Cache addcache = new Cache("test111", 150, true, false, 5, 2);
	    			cacheManager.addCache(addcache);
	    			addcache.put(new Element("key1","value1"));
	    	 }else{
	    		 cache= cacheManager.getCache("test111");
	    			Element element = cache.get("key1");
		    		System.out.println("element   " +element.getObjectKey());
	    	 }
	  }
}
