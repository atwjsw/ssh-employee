package com.atwjsw.ssh.service.impl;

import java.util.List;

import com.atwjsw.ssh.dao.EmployeeDao;
import com.atwjsw.ssh.domain.Department;
import com.atwjsw.ssh.domain.Employee;
import com.atwjsw.ssh.domain.PageBean;
import com.atwjsw.ssh.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findByPage(int currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage((int)num);
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);		
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);		
	}

	@Override
	public Employee findById(int eid) {
		return employeeDao.findById(eid);		
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);		
	}
	
	
}
