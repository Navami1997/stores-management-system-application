package com.capgemini.storesmanagementsystem.service;

import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.dao.ManufacturerDAO;
import com.capgemini.storesmanagementsystem.dao.ManufacturerDAOImpl;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class ManufacturerServiceImpl implements ManufacturerService{

	private ManufacturerDAO dao = new ManufacturerDAOImpl();
	
	/*
	 * @Override public boolean addDealer(DealerInfoBean dealer) { return
	 * dao.addDealer(dealer); }
	 */

	@Override
	public boolean setCostPrice(ProductInfoBean product,UserInfoBean bean) {
		return dao.setCostPrice(product,bean);
	}

	@Override
	public OrderDetails getPaymentDetails(int orderId,String name) {
		return dao.getPaymentDetails(orderId,name);
	}

	@Override
	public UserInfoBean login(String name, String password) {
		return dao.login(name, password);
	}

	@Override
	public boolean addProduct(UserInfoBean bean,ProductInfoBean prod) {
		return dao.addProduct(bean,prod);
	}

	@Override
	public Set<ProductInfoBean> getAllProducts(UserInfoBean bean) {
		return dao.getAllProducts(bean);
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
	public boolean checkProductAvailability(int id, UserInfoBean bean) {
		// TODO Auto-generated method stub
		return dao.checkProductAvailability(id, bean);
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
	public boolean setDeliveredDate(String date, int id, UserInfoBean customer) {
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

	@Override
	public boolean removeManufacturer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
