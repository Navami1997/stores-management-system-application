package com.capgemini.storesmanagementsystem.service;

import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public interface CustomerService extends StoresManagementSystem{
	public boolean buyProduct(UserInfoBean dealer,OrderDetails orders,UserInfoBean customer,String pname);
	public OrderDetails getOrderDetails(int id,UserInfoBean customer);
	public UserInfoBean login(String email, String password);
	public boolean checkEmailAvailability(String email);
	public boolean checkIdAvailability(int id);
	public void autoBuy(UserInfoBean bean,String name);
}
