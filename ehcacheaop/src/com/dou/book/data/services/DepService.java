package com.dou.book.data.services;

import com.dou.book.data.pojo.Department;
import com.dou.book.data.pojo.Employer;

public interface DepService {
	Department getDptAndEmps(String name);
	Employer  getEmployerByEName(String eName);
	
}
