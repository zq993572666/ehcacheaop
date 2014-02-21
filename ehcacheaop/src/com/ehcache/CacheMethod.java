package com.ehcache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheMethod {

	@CachePut("young")

public String getYoung(String str) {

System.out.println("method is running...");

return getData(str);

}
public String getData(String str){
	System.out.println("data   console start ");
	if(str.equals("1")){
		str="1";
	}else{
		str="2";
	}
	System.out.println("data   console end ");
	return str;
}
}
