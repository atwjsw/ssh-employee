package com.atwjsw.ssh.service;

import com.atwjsw.ssh.domain.Employee;
import com.atwjsw.ssh.domain.PageBean;

public interface EmployeeService {
	
	public Employee login(Employee employee);

	public PageBean<Employee> findByPage(int currPage);

	public void save(Employee employee);

	public Employee findById(int eid);

	public void update(Employee employee);

	public void delete(Employee employee);

	
}
