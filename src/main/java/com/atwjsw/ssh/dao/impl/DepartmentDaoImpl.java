package com.atwjsw.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atwjsw.ssh.dao.DepartmentDao;
import com.atwjsw.ssh.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao  {

	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size()>0) {
			return list.get(0).intValue();
		}		
		return 0;
	}
	/*
	 * 分页查询部门
	 */
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class); 
		List<Department> departments = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return departments;
	}
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);		
	}
	@Override
	public void update(Department department) {		
		this.getHibernateTemplate().update(department);			
	}
	@Override
	public Department findById(int did) {		
		return this.getHibernateTemplate().get(Department.class, did);			
	}
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);		
	}
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");		
	}
}
