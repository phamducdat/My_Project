package com.hust.baseweb.applications.humanresource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.baseweb.applications.humanresource.entity.Department;
import com.hust.baseweb.applications.humanresource.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public Department save(String departmentName) {
		// TODO Auto-generated method stub
		
		Department dept = new Department();
		dept.setDepartmentName(departmentName);
		dept = departmentRepo.save(dept);
		return dept;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		
		List<Department> departments = departmentRepo.findAll();
		return departments;
	}
	
}
