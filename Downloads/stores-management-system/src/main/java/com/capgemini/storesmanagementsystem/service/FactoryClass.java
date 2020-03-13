package com.capgemini.storesmanagementsystem.service;

import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class FactoryClass {
	
	
	public static StoresManagementSystem getService(UserInfoBean obj) {
		StoresManagementSystem service;
		if(obj.getRole().equalsIgnoreCase("admin")) {
			service = new AdminServiceImpl();
			return service;
		} else if(obj.getRole().equalsIgnoreCase("manufacturer")) {
			service = new ManufacturerServiceImpl();
			return service;
		}else if(obj.getRole().equalsIgnoreCase("dealer")) {
			service = new DealerServiceImpl();
			return service;
		}else if(obj.getRole().equalsIgnoreCase("customer")) {
			service = new CustomerServiceImpl();
			return service;
		}
		else return null;
	}
}
