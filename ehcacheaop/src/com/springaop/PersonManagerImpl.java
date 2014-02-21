package com.springaop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class PersonManagerImpl {
	  private static List persons;  
	  
	    static {  
	        persons = new ArrayList();  
	          
	        persons.add("Wang");  
	        persons.add("zang");  
	        persons.add("Li");  
	        persons.add("song");  
	        persons.add("yan");  
	    }  
	      
	    public List getList(String p1,int int1) {  
	        System.out.println("getPerons from DB");  
	        return persons;  
	    }  
	      
}
