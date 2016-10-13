package com.atwjsw.ssh.dao;

import java.util.List;

import com.atwjsw.ssh.domain.Department;

public interface DepartmentDao {
	
	public int findCount();
	
	public List<Department> findByPage(int begin, int pageSize);

	public void save(Department department);

	public void update(Department department);

	public Department findById(int did);

	public void delete(Department department);

	public List<Department> findAll();

}
