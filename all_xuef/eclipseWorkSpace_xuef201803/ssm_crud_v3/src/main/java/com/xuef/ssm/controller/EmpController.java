package com.xuef.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuef.ssm.domain.Department;
import com.xuef.ssm.domain.Employee;
import com.xuef.ssm.domain.ResWithMSG;
import com.xuef.ssm.service.EmployeeService;

@Controller
public class EmpController {
	@Autowired
	private EmployeeService employeeService;
	
	public EmpController(){
		System.out.println("EmpController new......");
	}
	
	@ResponseBody // ���������Զ�תΪJSON
	@RequestMapping("/emps")
	public ResWithMSG getEmpsJSON(
			@RequestParam(value="pageNo", defaultValue="1")Integer pageNo){
		PageHelper.startPage(pageNo, 3);
		List<Employee> emps = employeeService.getEmps();
		// ��װ��ѯ��Ľ����ֻ��Ҫ�� pageInfo����ҳ��Ϳ���
		PageInfo pageInfo = new PageInfo(emps, 5);// 5Ϊ������ʾ��ҳ��
		ResWithMSG success = ResWithMSG.success().add("pageInfo", pageInfo);
		return success;
	}
	
	/**
	 * �޸ĺ󱣴�Ա����Ϣ
	 * @param emp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{eNo}", method=RequestMethod.PUT)
	public ResWithMSG saveEmp(Employee emp){
		System.out.println("save emp: " + emp);
		employeeService.saveEmp(emp);
		return ResWithMSG.success();
	}
	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
	@ResponseBody // ���������Զ�תΪJSON
	@RequestMapping("/depts")
	public ResWithMSG getDeptsJSON(){
		List<Department> depts = employeeService.getDepts();
		ResWithMSG success = ResWithMSG.success().add("depts", depts);
		return success;
	}
	/**
	 * ��ѯ����Ա������(��ҳ)
	 * ʹ�� pageHelper ���
	 * @return
	 */
	//@RequestMapping("/emps")
	public String getEmps(
			@RequestParam(value="pageNo", defaultValue="1")Integer pageNo,
			Model model){
		System.out.println("get /emps");
		PageHelper.startPage(pageNo, 3);
		List<Employee> emps = employeeService.getEmps();
		// ��װ��ѯ��Ľ����ֻ��Ҫ�� pageInfo����ҳ��Ϳ���
		PageInfo pageInfo = new PageInfo(emps, 5);// 5Ϊ������ʾ��ҳ��
		model.addAttribute("pageInfo", pageInfo);
		return "emps-list";
	}
}
