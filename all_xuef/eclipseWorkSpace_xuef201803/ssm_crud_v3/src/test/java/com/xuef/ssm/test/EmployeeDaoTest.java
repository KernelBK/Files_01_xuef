package com.xuef.ssm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xuef.ssm.dao.DepartmentMapper;
import com.xuef.ssm.dao.EmployeeMapper;
import com.xuef.ssm.domain.Department;
import com.xuef.ssm.domain.Employee;

public class EmployeeDaoTest {
	private ApplicationContext ioc;
	private EmployeeMapper employeeMapper;
	private DepartmentMapper departmentMapper;
	@Before
	public void init(){
		// 获取IOC容器
		ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 得到mapper的实例
		employeeMapper = ioc.getBean(EmployeeMapper.class);
		departmentMapper = ioc.getBean(DepartmentMapper.class);
	}
	@Test
	public void testselectByExample() {
		// ??? EmployeeExample 怎么使用
		List<Employee> list = employeeMapper.getEmps();
		System.out.println(list);
	}
	@Test
	public void test(){
		Department d = departmentMapper.getDeptById(20);
		System.out.println(d);
	}
	@Test
	public void test1(){
		Employee e = employeeMapper.getEmpById(1001);
		System.out.println(e);
	}
}
