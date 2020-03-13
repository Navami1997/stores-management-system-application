package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public interface DealerService extends StoresManagementSystem{
	public boolean placeOrder(OrderDetails order,UserInfoBean dealer);
	public boolean setSellingPrice(UserInfoBean dealer,int id,double price);
	public int getNumberOfProducts(String name,UserInfoBean dealer);
	public UserInfoBean login(String name, String password);
	public boolean register(UserInfoBean bean);
	public OrderDetails getPaymentDeatils(int oid,UserInfoBean dealer);
	public boolean checkIdAvailability(int id);
	public boolean checkNameAvailability(String name) ;
	public boolean setDeliveredDate(String date,int id,UserInfoBean dealer);
	public boolean setMinimumQuantity(int minimumQuantity,int pid,UserInfoBean user);
}
