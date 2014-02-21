package com.dou.book.data.pojo;

public class Employer {  
    private String em_id;  
    private String name;  
    private String station;  
    private String work_years;  
    private String create_date;  
         private Department dpt; //隶属于哪个部门  
    public Department getDpt() {  
        return dpt;  
    }  
  
    public void setDpt(Department dpt) {  
        this.dpt = dpt;  
    }  
  
      
  
  
    public String getEm_id() {  
        return em_id;  
    }  
  
    public void setEm_id(String em_id) {  
        this.em_id = em_id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getStation() {  
        return station;  
    }  
  
    public void setStation(String station) {  
        this.station = station;  
    }  
  
    public String getWork_years() {  
        return work_years;  
    }  
  
    public void setWork_years(String work_years) {  
        this.work_years = work_years;  
    }  
  
    public String getCreate_date() {  
        return create_date;  
    }  
  
    public void setCreate_date(String create_date) {  
        this.create_date = create_date;  
    }  
  
  
    public Employer() {  
    }  
}  