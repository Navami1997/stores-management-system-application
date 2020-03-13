package com.capgemini.storesmanagementsystem.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.db.CollectionDbClass;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;
import com.capgemini.storesmanagementsystem.service.DealerService;
import com.capgemini.storesmanagementsystem.service.DealerServiceImpl;
import com.capgemini.storesmanagementsystem.service.FactoryClass;
import com.capgemini.storesmanagementsystem.service.StoresManagementSystem;

public class ManufacturerDAOImpl implements ManufacturerDAO {


	@Override
	public UserInfoBean login(String name, String password) {
		Iterator<UserInfoBean> itr = CollectionDbClass.manufacturerSet.iterator();
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getUserName().equalsIgnoreCase(name) && bean.getPassword().equals(password)) {
				return bean;
			}
		}
		return null;
	}

	@Override
	public boolean setCostPrice(ProductInfoBean product,UserInfoBean bean) {
		
		Iterator<ProductInfoBean> itr = bean.getProduct().iterator();
		while(itr.hasNext()) {
			ProductInfoBean prod = itr.next();
			if(prod.getProductId()==product.getProductId()) {
				prod.setCostPrice(product.getCostPrice());
				return true;
			}
		}
		return false;
	}

	@Override
	public OrderDetails getPaymentDetails(int orderId,String name) {
		UserInfoBean user = new UserInfoBean();
		user.setRole("dealer");
		StoresManagementSystem dealerSer = FactoryClass.getService(user);
		for (UserInfoBean dealer : CollectionDbClass.dealerSet) {
			if(dealer.getUserName().equalsIgnoreCase(name)) {
				return dealerSer.getPaymentDeatils(orderId, dealer);
			}
		}
		return null;
	}

	@Override
	public boolean addProduct(UserInfoBean bean,ProductInfoBean prod) {
		return bean.getProduct().add(prod);
	}

	@Override
	public Set<ProductInfoBean> getAllProducts(UserInfoBean bean) {
		for (UserInfoBean man : CollectionDbClass.manufacturerSet) {
			if(man.getUserName().equalsIgnoreCase(bean.getUserName())) {
				return man.getProduct();
			}
		}
		return null;
	}

	@Override
	public boolean checkIdAvailability(int id) {
		Iterator<UserInfoBean> itr = CollectionDbClass.manufacturerSet.iterator();
		if(itr.hasNext()) {
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getId()==id) {
				return false;
			} 
		}
		return true;
	 } else {
		return true;
	}
	}
	
	@Override
	public boolean checkNameAvailability(String name) {
		Iterator<UserInfoBean> itr = CollectionDbClass.manufacturerSet.iterator();
		if(itr.hasNext()) {
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getUserName().equalsIgnoreCase(name)) {
				return false;
			} 
		}
		return true;
	 } else {
		return true;
	}
	}

	@Override
	public boolean checkProductAvailability(int id,UserInfoBean bean) {
		Iterator<ProductInfoBean> itr = bean.getProduct().iterator();
		if(itr.hasNext()) {
		while (itr.hasNext()) {
			ProductInfoBean prod = itr.next();
			if (prod.getProductId()==id) {
				return false;
			} 
		}
		return true;
	 } else {
		return true;
	}
	}

}
