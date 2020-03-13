package com.capgemini.storesmanagementsystem.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.capgemini.storesmanagementsystem.db.CollectionDbClass;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class DealerDAOImpl implements DealerDAO {

	@Override
	public boolean placeOrder(OrderDetails order, UserInfoBean bean) {
				LocalDate date = LocalDate.now();
				order.setDateOfOrder(date);
				order.setStatus("Not yet Delivered");
				order.setDateOfDelivery(date.plusDays(2));
				order.getDealers().add(bean);
				bean.getOrders().add(order);
				return true;
	}

	@Override
	public UserInfoBean login(String name, String password) {
		Iterator<UserInfoBean> itr = CollectionDbClass.dealerSet.iterator();
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getUserName().equalsIgnoreCase(name) && bean.getPassword().equals(password)) {
				return bean;
			}
		}
		return null;
	}

	@Override
	public boolean setSellingPrice(UserInfoBean dealer, int id,double price) {
		for (ProductInfoBean prod : dealer.getProduct()) {
			if(prod.getProductId()==id) {
				prod.setSellingPrice(price);
				return true;
			}
		}
		return false;
	}
	 

	@Override
	public int getNumberOfProducts(String name, UserInfoBean dealer) {
		for (UserInfoBean bean : CollectionDbClass.dealerSet) {
			if (dealer.getUserName().equalsIgnoreCase(bean.getUserName())) {
				for (ProductInfoBean prod : bean.getProduct()) {
					if (prod.getProductName().equals(name))
						return prod.getQuantity();
				}
			}
		}
		return 0;
	}

	@Override
	public boolean register(UserInfoBean bean) {
		CollectionDbClass.dealerSet.add(bean);
		return true;
	}

	@Override
	public OrderDetails getPaymentDeatils(int oid,UserInfoBean dealer) {
		for (OrderDetails order : dealer.getOrders()) {
			if(order.getOrderId()==oid) {
				return order;
			}
		}
		return null;
	}

	@Override
	public boolean checkIdAvailability(int id) {
		Iterator<UserInfoBean> itr = CollectionDbClass.dealerSet.iterator();
		if(itr.hasNext()) {
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getId()==id) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	 } else {
		return true;
	}
	}

	@Override
	public boolean checkNameAvailability(String name) {
		Iterator<UserInfoBean> itr = CollectionDbClass.dealerSet.iterator();
		if(itr.hasNext()) {
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getUserName().equalsIgnoreCase(name)) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	 } else {
		return true;
	}
	}

	@Override
	public boolean setDeliveredDate(String date,int id,UserInfoBean dealer) {
		
		for (OrderDetails order : dealer.getOrders()) {
			if(order.getOrderId()==id) {
				Period p1 = Period.between(order.getDateOfOrder(), order.getDateOfDelivery());
				LocalDate deliveredDate = LocalDate.parse(date);
				if(deliveredDate.isBefore(order.getDateOfOrder())) {
					return false;
				} else {
				Period p2 = Period.between(deliveredDate, order.getDateOfDelivery());
				if(p2.getDays()<=p1.getDays()) {
					order.setStatus("Delivered");
					return true;
				} else {
					order.setStatus("Order Delivered Lately");
					return true;
				}
				}
			}
		}
		
		
		return false;
	}

	@Override
	public boolean setMinimumQuantity(int minimumQuantity, int pid,UserInfoBean user) {
		for (ProductInfoBean prod : user.getProduct()) {
			if(prod.getProductId()==pid) {
				prod.setMinimumQuantity(minimumQuantity);
				return true;
			}
		}
		return false;
	}
}
