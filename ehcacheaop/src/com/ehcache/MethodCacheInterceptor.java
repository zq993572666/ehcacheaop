package com.ehcache;

import java.io.Serializable;  
  
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;  
import org.aopalliance.intercept.MethodInvocation;  
import org.springframework.beans.factory.InitializingBean;  
import org.springframework.cache.ehcache.EhCacheCacheManager;
  

  
public class MethodCacheInterceptor implements MethodInterceptor, InitializingBean{  
	private EhCacheCacheManager methodCache;
	private CacheManager cacheManager;
    /* 
     * 首先有一点要明白的是：invoke的触发都在由于DAO或sevlet的数据访问时才会调用到 
     */  
    //invoke方法会在spring配置文件里的，指明的cache拦截的方法的调用时，自动触发它，如这个项目里，当运行TestSpringAopEhcache.java类时，在showPersonsInfo方法里调用到personManager.getList()方法时，它就会先调到这里来执行，执行完才行下执行它的业务  
    public Object invoke(MethodInvocation invocation) throws Throwable {  
    	cacheManager=(CacheManager) methodCache.getCacheManager();
        String targetName = invocation.getThis().getClass().getName();//这个表示哪个类调用（或触发）了这个MethodCacheInterceptor，如里的:manager.PersonMagagerImpl  
        String methodName = invocation.getMethod().getName();//这个表示哪个方法触发了这个类（MethodCacheInterceptor）方法（invoke）的调用，如这里的:getList  
        Object[] arguments = invocation.getArguments();//调用的参数,这里没有参数  
        Object result;  
        Cache cache;
        String cacheKey = getCacheKey(targetName, methodName, arguments);//这里得出的是:manager.PersonManagerImpl.getList  
      
     cache=(Cache) cacheManager.getCache(cacheKey);
        System.out.println("拦截了 "+cacheKey+"方法");
        Element   element ;
        if (cache == null) {  
            // call target/sub-interceptor  
        	System.out.println(cacheKey+"方法开始");
            result = invocation.proceed();//这个就是调用数据访问方法，如这里是调用manager.PersonManagerImpl.getList(),并用result保存执行的结果（数据访问的结果）,如这里调用了getList()方法，会先打印出"get Person from DB" ，然后将结果集放入到result里面去，这里由于使用的是自己配置只能放入10个元素的ehcache，所以这里的result是ArrayList<E> ，它里面存放的是elementData[10]，并将getList得到的结果放入到elementData里面去了
            System.out.println(cacheKey+"方法结束");
            System.out.println("set into cache");  
            // cache method result  
            //下面方法执行后，将cacheKey与数据集连起来，cacheKey是用来标识这个element的标志，我们可以有多个element(各自是来自不同的数据访问方法而形成的)，区分它们就是用cacheKey， 
            Element e=new Element( "cacheKey", (Serializable) result);
            cache = new Cache(cacheKey, 150, true, false, 5, 2);
            cacheManager.addCache(cache);
            cache.put(e);//放入cache中  
        }  
	        System.out.println("从 cache里取");//完成cache操作  
	        cache=(Cache) cacheManager.getCache(cacheKey);
	        element=   cache.get(cacheKey);
	         result=element.getObjectValue();  
        
        return result;
    }  
  
      
    private String getCacheKey(String targetName, String methodName,  
            Object[] arguments) {  
        StringBuffer sb = new StringBuffer();  
        sb.append(targetName).append(".").append(methodName);  
        if ((arguments != null) && (arguments.length != 0)) {  
            for (int i = 0; i < arguments.length; i++) {  
                sb.append(".").append(arguments[i]);  
            }  
        }  
  
        return sb.toString();  
    }  
  
    public void afterPropertiesSet() throws Exception {  
        /*if(null == cache) {  
            throw new IllegalArgumentException("Cache should not be null.");  
        }  */
    }
	public EhCacheCacheManager getMethodCache() {
		return methodCache;
	}
	public void setMethodCache(EhCacheCacheManager methodCache) {
		this.methodCache = methodCache;
	}
	public CacheManager getCacheManager() {
		return cacheManager;
	}
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}





  
}  