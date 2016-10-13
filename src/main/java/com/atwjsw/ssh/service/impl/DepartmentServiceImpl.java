package com.atwjsw.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atwjsw.ssh.dao.DepartmentDao;
import com.atwjsw.ssh.domain.Department;
import com.atwjsw.ssh.domain.PageBean;
import com.atwjsw.ssh.service.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	
	public List<Department> findAll() {		
		List<Department> departments = departmentDao.findAll();
		return departments;
	}

	@Override
	public PageBean<Department> findByPage(int currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage((int)num);
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);		
		return pageBean;
	}

	@Override
	public void save(Department department) {
		departmentDao.save(department);		
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);		
	}

	@Override
	public Department findById(int did) {
		return departmentDao.findById(did);
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);		
	}
}
