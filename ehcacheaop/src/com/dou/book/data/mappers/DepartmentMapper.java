package com.dou.book.data.mappers;

import java.util.List;

import com.dou.book.data.pojo.Department;

public interface DepartmentMapper {  
    public void addDepartMent(Department dpt);  
  
    public Department queryByDpName(String dp_name);  
  
    //public Department getDepartmentById(String dp_id);  
    public List<Department> queryAllDepartment();  
  
    public void updateDepartment(Department dpt);  
  
}  