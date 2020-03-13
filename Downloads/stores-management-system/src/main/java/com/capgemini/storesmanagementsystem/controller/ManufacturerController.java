package com.capgemini.storesmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dto.OrderDetails;
import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;
import com.capgemini.storesmanagementsystem.exception.EnterValidInputException;
import com.capgemini.storesmanagementsystem.exception.IdAlreadyExistsException;
import com.capgemini.storesmanagementsystem.service.FactoryClass;
import com.capgemini.storesmanagementsystem.service.StoresManagementSystem;
import com.capgemini.storesmanagementsystem.validation.Validations;

public class ManufacturerController {
	static Logger log = Logger.getLogger(ManufacturerController.class);
	Scanner sc = new Scanner(System.in);
	Validations val = new Validations();
	boolean manufacturerFlag = true;

	public void manufacturer(UserInfoBean manufacturer) {
		StoresManagementSystem manSer = FactoryClass.getService(manufacturer);
		
		while (true) {
			log.info("Welcome Manufacturer");
			log.info("Operation you would like to perform ?");
			log.info(" 1. Add Product \n 2. Set CostPrice \n"
					+ " 3. Get Payment Details \n 4. Get All Products \n " + "5. Exit as Manufacturer");
			log.info("Enter Your Choice");
			log.info("===================================================================="
					+ "==========================================================");
			int manufacturerChoice;
			try {
				manufacturerChoice = sc.nextInt();
				switch (manufacturerChoice) {
				case 1:
					log.info("Add Product");
					ProductInfoBean product = new ProductInfoBean();
					log.info("Enter Product Id");
					try {
						int	pid = sc.nextInt();
						if(manSer.checkProductAvailability(pid,manufacturer)) {
						product.setProductId(pid);
						log.info("Enter Product Cost");
						
						product.setCostPrice(sc.nextDouble());
						//manufacturer.setProductCost(productCost);
						log.info("Enter Product Name");
						product.setProductName(sc.next());

						log.info("Enter Description about Product");
						product.setDescription(sc.next());
						if(manSer.addProduct(manufacturer,product)) {
							log.info("Product Added Successfully");
						}
						}
						else {
							try {
								throw new IdAlreadyExistsException();
							} catch(IdAlreadyExistsException exp) {
								System.err.println(exp.getMessage());
								break;
							}
						}
					
					
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							System.err.println(exp.getMessage());
							
							/*
							 * ManufacturerService ser = new ManufacturerServiceImpl();
							 * ser.login(manufacturer.getUserName(), manufacturer.getPassword());
							 */
						}
					}
					break;
				case 2:
					log.info("Enter Product id");
					ProductInfoBean prod = new ProductInfoBean();
					
						prod.setProductId(sc.nextInt());
					
					log.info("Enter new Cost Price");
					prod.setCostPrice(sc.nextDouble());
					if (manSer.setCostPrice(prod, manufacturer)) {
						log.info("Updation Successful");
					} else {
						log.info("Updation Unsuccessfull");
					}
					break;
				case 3:
					log.info("Enter Order Id to get Payment Details");
					int oid = sc.nextInt();
					log.info("Enter Dealer name");
					sc.nextLine();
					String dname = sc.nextLine();
					OrderDetails bean = manSer.getPaymentDetails(oid, dname);

					if (bean != null) {
						log.info(" Order Id " + bean.getOrderId() + " \t ProductName " + bean.getProductName()
								+ " \t Date Of Order " + bean.getDateOfOrder() + " \t Amount " + bean.getAmount()
								+ " \t Date of Delivery " + bean.getDateOfDelivery());
					} else {
						log.info("Incorrect Order details");
					}
					break;
				case 4:
					Set<ProductInfoBean> prods = manSer.getAllProducts(manufacturer);
					log.info("===================================================================="
							+ "==========================================================");
					for (ProductInfoBean productInfoBean : prods) {
						log.info("Product Name " + productInfoBean.getProductName()+"\t Product Cost "
					+productInfoBean.getCostPrice());
					}
					log.info("===================================================================="
							+ "==========================================================");
					break;
				case 5:
					manufacturerFlag = false;
					break;
				}
			} catch (InputMismatchException e) {
				try {
					throw new EnterValidInputException();
				} catch (EnterValidInputException exp) {
					System.err.println(exp.getMessage());
					StoresManagementApp.start();
					/*
					 * ManufacturerService ser = new ManufacturerServiceImpl();
					 * ser.login(manufacturer.getUserName(), manufacturer.getPassword());
					 */
				}
			}
			if (manufacturerFlag == false)
				break;
		}
		//manufacturer(manufacturer);
	}
}
