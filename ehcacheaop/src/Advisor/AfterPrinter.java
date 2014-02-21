package Advisor;

import java.lang.reflect.Method;

import net.sf.ehcache.Cache;

import org.springframework.aop.AfterReturningAdvice;

public class AfterPrinter implements AfterReturningAdvice{
    private Cache cache;  
    
    public void setCache(Cache cache) {  
        this.cache = cache;  
    }  
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("returnValue"+returnValue);
		System.out.println("method  "+method.getName());
		System.out.println("参数"+"---------start");
		for(Object o:args){
			System.out.println(o);
		}
		System.out.println("参数"+"---------end");
		System.out.println("谁调用了这个方法"+target.getClass().getName());
		
	}

}
