package com.xuef.example.controller;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;

import com.xuef.example.domain.Employee;
import com.xuef.example.service.EmployeeService;

/**
 * 处理员工管理相关请求
 * @author moveb
 */
@Controller
public class EmployeeController {
	@Inject
	private EmployeeService employeeService;
	
	public EmployeeController(){
		System.out.println("EmployeeController Construct...");
	}
	/**
	 * 进入员工列表页面
	 * @param param
	 * @return
	 */
	@Action("get:/emps")
	public View index(Param param){
		System.out.println("get:/emps");
		List<Employee> empList = employeeService.getEmpList();
		return new View("emps.jsp").addModel("emp-list", empList);
	}
	
	/**
	 * 显示员工详细信息
	 * @param param
	 * @return
	 */
	@Action("get:/emp_show")
	public View show(Param param){
		long id = param.getLong("id");
		Employee emp = employeeService.getEmp(id);
		return new View("emp-detail.jsp").addModel("emp", emp);
	}
	
	/**
	 * 进入员工创建 页面
	 * @param param
	 * @return
	 */
	@Action("get:/emp_create")
	public View create(Param param){
		return new View("emp-create.jsp");
	}
	
	/**
	 * 处理 创建员工 请求
	 * @param param
	 * @return
	 */
	@Action("post:/emp_create")
	public Data createSubmit(Param param){
		Map<String, Object> fieldMap = param.getMap();
		boolean result = employeeService.createEmp(fieldMap);
		
		// 普通情况下，可返回JSP页面; 在 Ajax请求时，需要返回JSON数据
		return new Data(result);
	}
}
