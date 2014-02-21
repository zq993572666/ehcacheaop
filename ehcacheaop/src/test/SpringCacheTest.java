package test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ehcache.CacheMethod;



public class SpringCacheTest {
/*	@Resource
	CacheManager manager;
	@Resource
	CacheMethod method;*/
	public static void main(String[] args) {
		testGetYoung();
	}
	public static void testGetYoung() {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"classpath*:applicationContext-ehcache.xml");
	// CacheMethod method = new CacheMethod();这样得到的实例不在Spring的管理之中，也无法Cache
		CacheMethod method= (CacheMethod) act.getBean("cacheMethod");
		EhCacheCacheManager manager=(EhCacheCacheManager) act.getBean("cacheManager");
	String s = method.getYoung("1");
	System.out.println(s);
	String s1 = method.getYoung("1");
	System.out.println(s1);
	/*String s1 = method.getYoung("str");
	System.out.println(s1);*/
	/*Set<String> names=   (Set<String>) manager.getCacheNames();
	for(String str:names){
		System.out.println("ehcacheKey="+str);
	}
	Cache young = manager.getCache("young");// 得到cache
	System.out.println("Cache named 'young':" + young);*/
	}
}
