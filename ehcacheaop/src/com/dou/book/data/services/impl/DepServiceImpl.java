package com.dou.book.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dou.book.data.mappers.DepartmentMapper;
import com.dou.book.data.mappers.EmployerMapper;
import com.dou.book.data.pojo.Department;
import com.dou.book.data.pojo.Employer;
import com.dou.book.data.services.DepService;
@Service("depService")
@SuppressWarnings("unchecked")
public class DepServiceImpl implements DepService {
	@Autowired
private DepartmentMapper departmentMapper;
	@Autowired
	private EmployerMapper employerMapper;
	@Override
	public Department getDptAndEmps(String name) {
		// TODO Auto-generated method stub
		Department department =departmentMapper.queryByDpName(name);
		return department;
		
	}
	@Override
	public Employer getEmployerByEName(String eName) {
		// TODO Auto-generated method stub
		return employerMapper.getEmpByName(eName);
	}
	
}
