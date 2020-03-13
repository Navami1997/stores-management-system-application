
package com.capgemini.storesmanagementsystem.service;

import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public interface ManufacturerService extends StoresManagementSystem {
	//public boolean addDealer(DealerInfoBean dealer);
	public boolean setCostPrice(ProductInfoBean product,UserInfoBean bean);
	public OrderDetails getPaymentDetails(int orderId,String name);
	public UserInfoBean login(String name, String password);
	public boolean addProduct(UserInfoBean bean,ProductInfoBean prod);
	public Set<ProductInfoBean> getAllProducts(UserInfoBean bean);
	public boolean checkIdAvailability(int id);
	public boolean checkNameAvailability(String name) ;
	public boolean checkProductAvailability(int id,UserInfoBean bean);
}
