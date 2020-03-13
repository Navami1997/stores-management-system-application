package com.capgemini.storesmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.db.CollectionDbClass;
import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;
import com.capgemini.storesmanagementsystem.exception.EnterValidInputException;
import com.capgemini.storesmanagementsystem.service.FactoryClass;
import com.capgemini.storesmanagementsystem.service.StoresManagementSystem;

public class CustomerController {
	static Logger log = Logger.getLogger(CustomerController.class);
	
	Scanner sc = new Scanner(System.in);
	boolean customerFlag = true;
	public void customer(UserInfoBean customer) {
		StoresManagementSystem cusSer = FactoryClass.getService(customer);
		while (customerFlag) {
			log.info("Welcome Customer");
			log.info("Available Choices are..");
			log.info(" 1. Buy Product \n " + "2. Get Order Details \n" + " 3. Exit");
			log.info("Enter Your Choice");
			log.info("===================================================================="
					+ "==========================================================");
			try {
				int customerChoice = sc.nextInt();
				switch (customerChoice) {

				case 1:
					Set<UserInfoBean> prods = CollectionDbClass.dealerSet;
					Iterator<UserInfoBean> itr = prods.iterator();
					log.info("Available Products are.");
					while (itr.hasNext()) {
						UserInfoBean bean = itr.next();
						for (ProductInfoBean product : bean.getProduct()) {
							log.info("Dealer Name : " + bean.getUserName() + " \t Product Name : "
									+ product.getProductName());
						}
					}
					log.info("Enter Product You Want to Buy");
					UserInfoBean dealer = new UserInfoBean();
					sc.nextLine();
					String pname = sc.nextLine();
					log.info("Enter Dealer Name");
					dealer.setUserName(sc.nextLine());
					//log.info("Enter Order Id");
					OrderDetails corder = new OrderDetails();
					//try {
						corder.setOrderId(customer.getOrders().size()+1);
					/*
					 * } catch (InputMismatchException e) { try { throw new
					 * EnterValidInputException(); } catch (EnterValidInputException exp) {
					 * System.err.println(exp.getMessage()); break; } }
					 */
					if (cusSer.buyProduct(dealer, corder, customer, pname)) {
						cusSer.autoBuy(dealer, pname);
						log.info("Order Placed Successfully");
					} else {
						log.info("Order Placement has been failed");
					}
					break;
				case 2:
					log.info("Enter Order Id to get Payment Details");
					int oid;
					try {
						oid = sc.nextInt();
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							System.err.println(exp.getMessage());
							break;
						}
					}
					OrderDetails bean = cusSer.getOrderDetails(oid,customer);
					if (bean != null) {
						log.info(" Order Id " + bean.getOrderId() + " \t ProductName "
								+ bean.getProductName() + " \t Date Of Order " + bean.getDateOfOrder()
								+ " \t Amount " + bean.getAmount()+"\t Status"+bean.getStatus());
					} else {
						log.info("Order not found");
					}
					break;
				
				case 3:
					customerFlag = false;
					break;
				}
			} catch (InputMismatchException e) {
				try {
					throw new EnterValidInputException();
				} catch (EnterValidInputException exp) {
					System.err.println(exp.getMessage());
					StoresManagementApp.start();
				}
			}
			if (customerFlag == false)
				break;
		}
	}
}
