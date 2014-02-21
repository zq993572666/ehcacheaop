package com.dou.book.data.mappers;

import java.util.List;

import com.dou.book.data.pojo.Employer;

public interface EmployerMapper {
	public Employer getEmpByName(String name);  
	  
    public List<Employer> getAllEmpDpt(String dp_id);  
}
