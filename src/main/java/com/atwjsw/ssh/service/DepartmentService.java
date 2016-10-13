package com.atwjsw.ssh.service;

import java.util.List;

import com.atwjsw.ssh.domain.Department;
import com.atwjsw.ssh.domain.Employee;
import com.atwjsw.ssh.domain.PageBean;

public interface DepartmentService {
	
		public PageBean<Department> findByPage(int currPage);

		public void save(Department department);

		public void update(Department department);

		public Department findById(int did);

		public void delete(Department department);

		public List<Department> findAll();
		
}
