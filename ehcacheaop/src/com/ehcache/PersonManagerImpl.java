package com.ehcache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class PersonManagerImpl {
	  private  List<String> persons=new ArrayList<String>();  
	  
	    static {  
	       
	    }  
	      
	    public List getList(String p1,int int1) {  
	        System.out.println("getPerons from DB");  
	        persons.add("Wang");  
	        persons.add("zang");  
	        persons.add("Li");  
	        persons.add("song");  
	        persons.add("yan");  
	        return persons;  
	    }  
	      
}
