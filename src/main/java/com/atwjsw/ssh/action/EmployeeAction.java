package com.atwjsw.ssh.action;

import java.util.List;

import com.atwjsw.ssh.domain.Department;
import com.atwjsw.ssh.domain.Employee;
import com.atwjsw.ssh.domain.PageBean;
import com.atwjsw.ssh.service.DepartmentService;
import com.atwjsw.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

	private Employee employee = new Employee();
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private int currPage = 1;

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	@Override
	public Employee getModel() {
		return this.employee;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String login() {
		System.out.println("login执行了");
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			this.addActionError("用户名或密码错误!");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		System.out.println(
				pageBean.getCurrPage() + "    " + pageBean.getTotalPage() + "    " + pageBean.getList().size());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public String saveUI() {
		List<Department> departments = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", departments);
		return "saveUI";
	}

	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	public String edit() {
		employee = employeeService.findById(employee.getEid());
		List<Department> departments = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", departments);
		return "editSuccess";	
	}
	
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";	
	}
	
	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";	
	}
}
