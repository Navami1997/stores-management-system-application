package com.capgemini.storesmanagementsystem.service;

import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.dao.AdminDAO;
import com.capgemini.storesmanagementsystem.dao.AdminDAOImpl;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class AdminServiceImpl implements AdminService{
	
	private AdminDAO dao = new AdminDAOImpl();

	@Override
	public boolean addManufacturer(UserInfoBean manufacturer) {
		return dao.addManufacturer(manufacturer);
	}

	@Override
	public UserInfoBean updateManufacturerDetails(UserInfoBean manufacturer) {
		return dao.updateManufacturerDetails(manufacturer);
	}

	@Override
	public UserInfoBean getManufacturerDetails(int id) {
		return dao.getManufacturerDetails(id);
	}

	@Override
	public List<UserInfoBean> getAllManufacturersDetails() {
		return dao.getAllManufacturersDetails();
	}
	
	@Override
	public boolean removeManufacturer(int id) {
		// TODO Auto-generated method stub
		return dao.removeManufacturer(id);
	}
	
	@Override
	public boolean buyProduct(UserInfoBean dealer, OrderDetails orders, UserInfoBean customer, String pname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderDetails getOrderDetails(int id, UserInfoBean customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkEmailAvailability(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void autoBuy(UserInfoBean bean, String name) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public boolean setDeliveredDate(String date, int id, UserInfoBean customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCostPrice(ProductInfoBean product, UserInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderDetails getPaymentDetails(int orderId, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoBean login(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduct(UserInfoBean bean,ProductInfoBean prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<ProductInfoBean> getAllProducts(UserInfoBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkIdAvailability(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNameAvailability(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkProductAvailability(int id, UserInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean placeOrder(OrderDetails order, UserInfoBean dealer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setSellingPrice(UserInfoBean dealer, int id, double price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfProducts(String name, UserInfoBean dealer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean register(UserInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderDetails getPaymentDeatils(int oid, UserInfoBean dealer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setMinimumQuantity(int minimumQuantity, int pid, UserInfoBean user) {
		// TODO Auto-generated method stub
		return false;
	}


}
