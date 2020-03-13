package com.capgemini.storesmanagementsystem.dao;

import java.time.LocalDate;
import java.util.Iterator;

import com.capgemini.storesmanagementsystem.db.CollectionDbClass;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class CustomerDAOImpl implements CustomerDAO {

	private DealerDAOImpl dealerImpl = new DealerDAOImpl();
	
	static boolean  flag = false;
	
	@Override
	public boolean buyProduct(UserInfoBean dealer, OrderDetails corder, UserInfoBean customer, String pname) {
		Iterator<UserInfoBean> itr = CollectionDbClass.dealerSet.iterator();
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getUserName().equalsIgnoreCase(dealer.getUserName())) {
				for (ProductInfoBean prods : bean.getProduct()) {
					if (prods.getProductName().equals(pname)) {
						corder.setProductName(prods.getProductName());
						LocalDate date = LocalDate.now();
						corder.setDateOfOrder(date);
						corder.setStatus("Not yet Delivered");
						corder.setDateOfDelivery(date.plusDays(3));
						corder.setAmount(prods.getSellingPrice());
						customer.getOrders().add(corder);

						int quantity = prods.getQuantity() - 1;
						prods.setQuantity(quantity);
						if (prods.getQuantity() <= prods.getMinimumQuantity()) {
							flag=true;
						}

						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public UserInfoBean login(String email, String password) {
		Iterator<UserInfoBean> itr = CollectionDbClass.customerSet.iterator();
		while (itr.hasNext()) {
			UserInfoBean bean = itr.next();
			if (bean.getEmail().equals(email)&& bean.getPassword().equals(password)) {
				return bean;
			}
		}
		return null;
	}

	@Override
	public OrderDetails getOrderDetails(int id, UserInfoBean customer) {
		for (OrderDetails order : customer.getOrders()) {
			if (order.getOrderId() == id) {
				return order;
			}
		}
		return null;
	}

	@Override
	public boolean checkEmailAvailability(String email) {
		Iterator<UserInfoBean> itr = CollectionDbClass.customerSet.iterator();
		if (itr.hasNext()) {
			while (itr.hasNext()) {
				UserInfoBean bean = itr.next();
				if (bean.getEmail().equals(email)) {
					return false;
				} 
			}
			return true;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkIdAvailability(int id) {
		Iterator<UserInfoBean> itr = CollectionDbClass.customerSet.iterator();
		if (itr.hasNext()) {
			while (itr.hasNext()) {
				UserInfoBean bean = itr.next();
				if (bean.getId() == id) {
					return false;
				} 
			}
			return true;
		} else {
			return true;
		}
	}

	@Override
	public void autoBuy(UserInfoBean dealer,String name) {
		
		if(flag) {
			for (UserInfoBean dealers : CollectionDbClass.dealerSet) {
				if(dealer.getUserName().equalsIgnoreCase(dealers.getUserName())) {
					for (ProductInfoBean prods : dealers.getProduct()) {
						if(prods.getProductName().equalsIgnoreCase(name)) {
							OrderDetails order = new OrderDetails();
							for (OrderDetails orders : dealers.getOrders()) {
								if(orders.getProductName().equalsIgnoreCase(name)) {
									
									prods.setQuantity(prods.getQuantity() * 2);
									int newOid = dealers.getOrders().size()+1;
									order.setOrderId(newOid);
									order.setAmount((prods.getCostPrice()*prods.getQuantity()));
									order.setStatus("Not yet Delivered");
									order.setProductName(prods.getProductName());
									LocalDate newDate = LocalDate.now();
									order.setDateOfOrder(newDate);
									order.setDateOfDelivery(LocalDate.now().plusDays(2));
									
									
								}
							}
							order.getDealers().add(dealers);
							dealers.getOrders().add(order);
							flag=false;
						}
					}
					
				}
			}
		}
		
	}


}
