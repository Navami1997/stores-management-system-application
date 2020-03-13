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

public class DealerController {
	static Logger log = Logger.getLogger(DealerController.class);
	Scanner sc = new Scanner(System.in);
	boolean dealerFlag = true;

	public void dealer(UserInfoBean dealer) {
		StoresManagementSystem dealerSer = FactoryClass.getService(dealer);
		while (dealerFlag) {
			log.info("Welcome Dealer");
			log.info("Operation you would like to perform ?");
			log.info(" 1. Place Order \n" + " 2. Set Selling Price \n" + " 3. Get Payment Details \n"
					+ " 4. Get All Products \n" + " 5. Get All Orders \n 6. Get NumberofProducts \n" + " 7. Is OrderDelivered \n 8. Set Minimum Quantity"
							+ "\n 9. Exit");
			log.info("Enter Your Choice");
			log.info("===================================================================="
					+ "==========================================================");
			try {
				int dealerChoice = sc.nextInt();
				switch (dealerChoice) {
				case 1:
					log.info("Enter Product Name");
					String productName = sc.next();
					log.info("Enter Manufacturer Name");
					String manName = sc.next();
					log.info("Enter Quantity");
					int quantity;
					try {
						quantity = sc.nextInt();
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							System.err.println(exp.getMessage());
							break;
						}
					}
					Iterator<UserInfoBean> itr = CollectionDbClass.manufacturerSet.iterator();
					while (itr.hasNext()) {
						UserInfoBean manBean = itr.next();
						
						if (manBean.getUserName().equalsIgnoreCase(manName)) {
							for (ProductInfoBean prod : manBean.getProduct()) {
								if (prod.getProductName().equalsIgnoreCase(productName)) {
									OrderDetails order = new OrderDetails();
									//log.info("Enter Order Id");
									try {
										ProductInfoBean product = new ProductInfoBean();
										//int oid = sc.nextInt();
										
										order.setOrderId(dealer.getOrders().size()+1);
										order.setProductName(prod.getProductName());
										product.setQuantity(quantity);
										product.setSellingPrice(prod.getCostPrice() + 50);
										order.setAmount(prod.getCostPrice()*quantity);
										product.setCostPrice(prod.getCostPrice());
										product.setProductName(prod.getProductName());
										product.setProductId(prod.getProductId());
										dealer.getProduct().add(product);
										
									} catch (InputMismatchException e) {
										try {
											throw new EnterValidInputException();
										} catch (EnterValidInputException exp) {
											System.err.println(exp.getMessage());
											break;
										}
									}
									if (dealerSer.placeOrder(order, dealer)) {
										log.info("Order Placed successfully");

									} else {
										log.info("Placing order has been failed");

									}
								} 
							} 
						} 
					}
					break;
				case 2:
					log.info("Enter Selling Price");
					double newPrice = sc.nextDouble();
					log.info("Enter Product Id");
					int pid;
					try {
						pid = sc.nextInt();
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							System.err.println(exp.getMessage());
							break;
						}
					}
					if (dealerSer.setSellingPrice(dealer, pid,newPrice)) {
						log.info("Price has been set Successfully");
					} else {
						log.info("No products are there to set price");
					}
					break;
				case 3:
					log.info("Enter Order Id");
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
					OrderDetails bean = dealerSer.getPaymentDeatils(oid,dealer);
					if (bean != null) {
						
								log.info(" Order Id " + bean.getOrderId() + " \t ProductName " +
									bean.getProductName()
								+ " \t Date Of Order " + bean.getDateOfOrder()+" \t Date of Delivery" + bean.getDateOfDelivery()+
								" \t Amount " + bean.getAmount()+" \t Status = "+bean.getStatus());
							
						
					} else {
						log.info("Incorrect Order details");
					}
					break;
				case 4:
					Set<ProductInfoBean> prods = dealer.getProduct();
					if (prods != null) {
						for (ProductInfoBean productInfoBean : prods) {
							log.info("Product " + productInfoBean.getProductName()+" \t Selling Price : "+productInfoBean.getSellingPrice());
						}
					} else {
						log.info("Products not found");
					}
					break;
				case 5 : for (OrderDetails beanorder : dealer.getOrders()) {
					log.info(" Order Id " + beanorder.getOrderId() + " \t ProductName " +
							beanorder.getProductName()
						+ " \t Date Of Order " + beanorder.getDateOfOrder() + " \t Amount " + beanorder.getAmount()+
						" \t Status "+beanorder.getStatus());
				}
					break;
				case 6:
					log.info("Enter product Name");
					sc.nextLine();
					String name = sc.nextLine();
					int count = dealerSer.getNumberOfProducts(name, dealer);
					if(count!=0) {
					log.info("Product Name "+name+" \t Product Count is " + count);
					} else {
						log.info("Product Not found");
					}
					break;
				case 7:log.info("Enter Delivered Date");
				String date = sc.next();
				log.info("Enter Order Id");
				int orid = sc.nextInt();
				if(dealerSer.setDeliveredDate(date, orid, dealer)) {
					log.info("Order Delivered Successfully");
				} else {
					System.err.println("Please enter valid date");
				}
					break;
				
				case 8 : log.info("Enter Product Id");
				int prid = sc.nextInt();
				log.info("Enter Minimum Quantity");
				int minQ = sc.nextInt();
				if(dealerSer.setMinimumQuantity(minQ, prid, dealer)) {
					log.info("Price Updated ");
				} else {
					log.info("Price Updation failed");
				}
					break;
					
				case 9:
					dealerFlag = false;
					break;
				default:
					log.info("Enter valid choice");
				}

			} catch (InputMismatchException e) {
				try {
					throw new EnterValidInputException();
				} catch (EnterValidInputException exp) {
					System.err.println(exp.getMessage());
					StoresManagementApp.start();
				}
			}
			if (dealerFlag == false)
				break;
		}
	}
}
