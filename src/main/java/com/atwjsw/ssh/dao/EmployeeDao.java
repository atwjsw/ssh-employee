package com.atwjsw.ssh.dao;

import java.util.List;

import com.atwjsw.ssh.domain.Employee;

public interface EmployeeDao {
	
	public Employee findByUsernameAndPassword(Employee employee);

	public int findCount();

	public List<Employee> findByPage(int begin, int pageSize);

	public void save(Employee employee);

	public Employee findById(int eid);

	public void update(Employee employee);

	public void delete(Employee employee);

}
