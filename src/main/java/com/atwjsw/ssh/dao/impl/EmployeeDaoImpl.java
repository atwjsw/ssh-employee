package com.atwjsw.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atwjsw.ssh.dao.EmployeeDao;
import com.atwjsw.ssh.domain.Department;
import com.atwjsw.ssh.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{
	
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ? ";

		List<Employee> employees = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		
		if (employees.size()>0) {
			return employees.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size()>0) {
			return list.get(0).intValue();
		}		
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class); 
		List<Employee> employees = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return employees;
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findById(int eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
		
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);	
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);		
	}

}
