package com.xuef.architect.customermgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.xuef.architect.customermgr.dao.CustomerDAO;
import com.xuef.architect.customermgr.vo.CustomerModel;

// Test
@Service("client")
public class Client {
	// 这个dao是怎么注入的???名字是否有什么要求???
	@Autowired
	private CustomerService service;
	
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client client = (Client) container.getBean("client");
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("1004");
		cm.setPwd("345678");
		cm.setRegisterTime("2018-04-03");
		cm.setShowName("Li");
		cm.setTrueName("Li");
		
		client.create(cm);
//		CustomerModel customerModel = client.getCusById(1);
//		System.out.println(customerModel);
		
	}

	private void create(CustomerModel cm) {
		service.create(cm);
	}

	private CustomerModel getCusById(int id) {
		return service.getByUuid(id);
	}
}
