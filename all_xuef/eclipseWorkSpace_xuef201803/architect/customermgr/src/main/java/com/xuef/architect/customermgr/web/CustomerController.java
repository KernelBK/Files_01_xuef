package com.xuef.architect.customermgr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuef.architect.customermgr.service.CustomerService;
import com.xuef.architect.customermgr.vo.CustomerModel;
import com.xuef.architect.customermgr.vo.CustomerQueryModel;
import com.xuef.architect.customermgr.vo.Msg;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@ResponseBody // 返回数据自动转为JSON
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public Msg getCustomersJSON(
			@RequestParam(value="pageNo", defaultValue="1")Integer pageNo){
		PageHelper.startPage(pageNo, 2);
		List<CustomerModel> customers = customerService.getByCondition(new CustomerQueryModel());
		// 包装查询后的结果。只需要将 pageInfo交给页面就可以
		PageInfo pageInfo = new PageInfo(customers, 5);// 5为连续显示的页数
		Msg success = Msg.success().add("pageInfo", pageInfo);
		System.out.println("success: " + success);
		return success;
	}
	
	/**
	 * 修改后保存
	 */
	@ResponseBody
	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.PUT)
	public void save(CustomerModel customerModel){
		System.out.println("save........." + customerModel);
		customerService.update(customerModel);
	}
	
	/**
	 * 新增客户
	 */
	@ResponseBody
	@RequestMapping(value="/customerAdd", method=RequestMethod.POST)
	public void add(CustomerModel customerModel){
		System.out.println("add2save: " + customerModel);
		customerModel.setPwd("123");
		customerModel.setTrueName(customerModel.getShowName());
		customerService.create(customerModel);
	}
	
	/**
	 * 删除客户
	 */
	@ResponseBody
	@RequestMapping(value="/customerDel/{uuid}", method=RequestMethod.DELETE)
	public void deleteOne(@PathVariable("uuid") String uuid){
		System.out.println("delete: " + uuid);
		customerService.delete(Integer.parseInt(uuid));
	}
}
