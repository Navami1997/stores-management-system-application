package com.capgemini.storesmanagementsystem.service;

import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.dao.DealerDAO;
import com.capgemini.storesmanagementsystem.dao.DealerDAOImpl;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class DealerServiceImpl implements DealerService{
	
	private DealerDAO dao = new DealerDAOImpl();

	@Override
	public boolean placeOrder(OrderDetails order, UserInfoBean dealer) {
		return dao.placeOrder(order, dealer);
	}

	@Override
	public boolean setSellingPrice(UserInfoBean dealer,int id,double price) {
		return dao.setSellingPrice(dealer,id,price);
	}

	@Override
	public int getNumberOfProducts(String name, UserInfoBean dealer) {
		return dao.getNumberOfProducts(name, dealer);
	}

	@Override
	public UserInfoBean login(String name, String password) {
		return dao.login(name, password);
	}

	@Override
	public boolean register(UserInfoBean bean) {
		return dao.register(bean);
	}

	@Override
	public OrderDetails getPaymentDeatils(int oid,UserInfoBean dealer) {
		return dao.getPaymentDeatils(oid,dealer);
	}

	@Override
	public boolean checkIdAvailability(int id) {
		return dao.checkIdAvailability(id);
	}

	@Override
	public boolean checkNameAvailability(String name) {
		return dao.checkNameAvailability(name);
	}

	@Override
	public boolean setDeliveredDate(String date,int id,UserInfoBean dealer) {
		return dao.setDeliveredDate(date,id,dealer);
	}

	@Override
	public boolean setMinimumQuantity(int minimumQuantity, int pid, UserInfoBean user) {
		return dao.setMinimumQuantity(minimumQuantity, pid, user);
	}

	@Override
	public boolean addManufacturer(UserInfoBean manufacturer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfoBean updateManufacturerDetails(UserInfoBean manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoBean getManufacturerDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoBean> getAllManufacturersDetails() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean checkProductAvailability(int id, UserInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeManufacturer(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
