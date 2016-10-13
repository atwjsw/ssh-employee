package com.atwjsw.ssh.action;

import java.util.List;

import com.atwjsw.ssh.domain.Department;
import com.atwjsw.ssh.domain.PageBean;
import com.atwjsw.ssh.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	
	private Department department = new Department();
	private DepartmentService departmentService;
	private int currPage = 1;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	@Override
	public Department getModel() {
		return this.department;
	}

	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		System.out.println(pageBean.getCurrPage() + "    " + pageBean.getTotalPage() + "    " + pageBean.getList().size());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";		
	}
	
	public String saveUI() {
		return "saveUI";	
	}
	
	public String save() {
		
		departmentService.save(department);
		return "saveSuccess";	
	}
	
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "editSuccess";	
	}
	
	public String update() {
		departmentService.update(department);
		return "updateSuccess";	
	}
	
	public String delete() {
		//级联删除必须先查询，在mapping文件里面设置cascade="delete"
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";	
	}
}
