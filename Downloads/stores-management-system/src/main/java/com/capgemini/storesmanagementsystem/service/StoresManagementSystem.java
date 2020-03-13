package com.capgemini.storesmanagementsystem.service;

import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public interface StoresManagementSystem {
	public boolean addManufacturer(UserInfoBean manufacturer);
	public UserInfoBean updateManufacturerDetails(UserInfoBean manufacturer);
	public UserInfoBean getManufacturerDetails(int id);
	public List<UserInfoBean> getAllManufacturersDetails();
	public boolean buyProduct(UserInfoBean dealer,OrderDetails orders,UserInfoBean customer,String pname);
	public OrderDetails getOrderDetails(int id,UserInfoBean customer);
	public boolean checkEmailAvailability(String email);
	public void autoBuy(UserInfoBean bean,String name);
	public boolean setDeliveredDate(String date,int id,UserInfoBean customer);
	public boolean setCostPrice(ProductInfoBean product,UserInfoBean bean);
	public OrderDetails getPaymentDetails(int orderId,String name);
	public UserInfoBean login(String name, String password);
	public boolean addProduct(UserInfoBean bean,ProductInfoBean prod);
	public Set<ProductInfoBean> getAllProducts(UserInfoBean bean);
	public boolean checkIdAvailability(int id);
	public boolean checkNameAvailability(String name) ;
	public boolean checkProductAvailability(int id,UserInfoBean bean);
	public boolean placeOrder(OrderDetails order,UserInfoBean dealer);
	public boolean setSellingPrice(UserInfoBean dealer,int id,double price);
	public int getNumberOfProducts(String name,UserInfoBean dealer);
	public boolean register(UserInfoBean bean);
	public OrderDetails getPaymentDeatils(int oid,UserInfoBean dealer);
	public boolean setMinimumQuantity(int minimumQuantity,int pid,UserInfoBean user);
	public boolean removeManufacturer(int id);
}
