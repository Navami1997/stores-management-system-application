package com.capgemini.storesmanagementsystem.service;

import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.dao.CustomerDAO;
import com.capgemini.storesmanagementsystem.dao.CustomerDAOImpl;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO dao = new CustomerDAOImpl();

	@Override
	public boolean buyProduct(UserInfoBean dealer, OrderDetails orders, UserInfoBean customer, String pname) {
		return dao.buyProduct(dealer, orders, customer, pname);
	}

	@Override
	public OrderDetails getOrderDetails(int id, UserInfoBean customer) {
		return dao.getOrderDetails(id, customer);
	}

	@Override
	public UserInfoBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean checkEmailAvailability(String email) {
		return dao.checkEmailAvailability(email);
	}

	@Override
	public boolean checkIdAvailability(int id) {
		return dao.checkIdAvailability(id);
	}

	@Override
	public void autoBuy(UserInfoBean bean, String name) {
		dao.autoBuy(bean, name);

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
	public boolean addProduct(UserInfoBean bean, ProductInfoBean prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<ProductInfoBean> getAllProducts(UserInfoBean bean) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public boolean removeManufacturer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setDeliveredDate(String date, int id, UserInfoBean customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
