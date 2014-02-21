package com.dou.book.data.pojo;

import java.util.List;

public class Department {  
	  
    private String dp_id;  
    private String dp_name;  
    private String cost_center;  
    private List<Employer> employerList;  
  
  
  
    public String getDp_id() {  
        return dp_id;  
    }  
  
    public void setDp_id(String dp_id) {  
        this.dp_id = dp_id;  
    }  
  
    public String getDp_name() {  
        return dp_name;  
    }  
  
    public void setDp_name(String dp_name) {  
        this.dp_name = dp_name;  
    }  
  
    public String getCost_center() {  
        return cost_center;  
    }  
  
    public void setCost_center(String cost_center) {  
        this.cost_center = cost_center;  
    }  
  
  
    public List<Employer> getEmployerList() {  
        return employerList;  
    }  
  
    public void setEmployerList(List<Employer> employerList) {  
        this.employerList = employerList;  
    }  
  
    public Department() {  
        super();  
  
    }  
}  