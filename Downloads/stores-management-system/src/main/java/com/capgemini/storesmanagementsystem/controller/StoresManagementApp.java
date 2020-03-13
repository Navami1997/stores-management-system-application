package com.capgemini.storesmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.db.CollectionDbClass;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;
import com.capgemini.storesmanagementsystem.exception.EmailAlreadyExistsException;
import com.capgemini.storesmanagementsystem.exception.EnterValidInputException;
import com.capgemini.storesmanagementsystem.exception.IdAlreadyExistsException;
import com.capgemini.storesmanagementsystem.exception.NameAlreadyExistsException;
import com.capgemini.storesmanagementsystem.service.FactoryClass;
import com.capgemini.storesmanagementsystem.service.StoresManagementSystem;
import com.capgemini.storesmanagementsystem.validation.Validations;

public class StoresManagementApp {
	static Logger log = Logger.getLogger(StoresManagementApp.class);
	public static void start() {

		Scanner sc = new Scanner(System.in);
		String uname;
		String password;
		Validations val = new Validations();
		boolean flag = true;
		while (flag) {
			UserInfoBean user = new UserInfoBean();
			log.info("Who You are..??");
			log.info("Available options \n " + "1. Admin \n " + "2. Manufacturer \n " + "3. Dealer \n "
					+ "4. Customer \n " + "5. Exit \n ");
			log.info("===================================================================="
					+ "==========================================================");
			log.info("Enter Your Choice");
			try {
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					log.info("Enter UserName");
					sc.nextLine();
					uname = sc.nextLine();
					log.info("Enter Password");
					password = sc.nextLine();
					if (uname.equals("Admin") && password.equals("admin@123")) {
						log.info("Admin Login Successful");
						UserInfoBean admin = new UserInfoBean();
						admin.setRole("admin");
						AdminController admins = new AdminController();
						admins.admin(admin);
					} else {
						log.info("Login Unsuccessful");
					}

					break;
				case 2:
					user.setRole("manufacturer");
					StoresManagementSystem manSer = FactoryClass.getService(user);
					log.info("Enter UserName");
					sc.nextLine();
					uname = sc.nextLine();
					log.info("Enter Password");
					password = sc.nextLine();
					if (val.passwordValidtion(password)) {
						UserInfoBean manufacturer = manSer.login(uname, password);
						if (manSer.login(uname, password) != null) {
							log.info("Manufacturer Login Successful");
							manufacturer.setRole("manufacturer");
							ManufacturerController controller = new ManufacturerController();
							controller.manufacturer(manufacturer);
						} else {
							log.info("Login Unsuccessful");
						}
					} else {
						log.info("Password Must contains more than 4 letters");
					}
					break;
				case 3:
					log.info(" 1. Register \n 2. Login \n Enter your choice...");
					
					user.setRole("dealer");
					StoresManagementSystem dealerSer = FactoryClass.getService(user);
					try {
						int ch = sc.nextInt();
						if (ch == 1) {
							UserInfoBean dealer = new UserInfoBean();
							log.info("Enter Name");
							sc.nextLine();
							String dealerName = sc.nextLine();
							if (dealerSer.checkNameAvailability(dealerName)) {
								if (val.nameValidation(dealerName)) {
									dealer.setUserName(dealerName);
									//log.info("Enter Dealer Id");
									try {
										int did = CollectionDbClass.dealerSet.size()+1;
										if (dealerSer.checkIdAvailability(did)) {
											dealer.setId(did);
										} else {
											try {
												throw new IdAlreadyExistsException();
											} catch (IdAlreadyExistsException exp) {
												System.err.println(exp.getMessage());
												break;
											}
										}
									} catch (InputMismatchException e) {
										try {
											throw new EnterValidInputException();
										} catch (EnterValidInputException exp) {
											log.info(exp.getMessage());
											break;
										}
									}
									log.info("Enter Password for Dealer");
									String dpassword = sc.next();
									if (val.passwordValidtion(dpassword)) {
										dealer.setPassword(dpassword);
										if (dealerSer.register(dealer)) {
											log.info("Dealer Registered Successfully");
										} else {
											log.info("Registration has been failed");
										}
									} else {
										log.info("Password must be greater than four letters");
									}
								} else {
									System.err.println("Enter Valid Name");
								}
							} else {
								try {
									throw new NameAlreadyExistsException();
								} catch (NameAlreadyExistsException e) {
									System.err.println(e.getMessage());
								}
							}
						} else if (ch == 2) {
							log.info("Enter UserName");
							sc.nextLine();
							uname = sc.nextLine();
							log.info("Enter Password");
							password = sc.nextLine();
							if (val.passwordValidtion(password)) {
								UserInfoBean dealer = dealerSer.login(uname, password);
								if (dealer != null) {
									log.info("Dealer Login Successful");
									DealerController controller = new DealerController();
									dealer.setRole("dealer");
									controller.dealer(dealer);
								} else {
									log.info("Login Unsuccessful");
								}
							} else {
								log.info("Password Must contains more than 4 letters");
							}
						} else {
							log.info("Enter valid choice");
						}
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							log.info(exp.getMessage());
						}
					}

					break;
				case 4:
					log.info(" 1. Register \n 2. Login \n Enter your choice...");
					user.setRole("customer");
					StoresManagementSystem cusSer = FactoryClass.getService(user);
					try {
						int ch = sc.nextInt();
						if (ch == 1) {
							/*
							 * log.info("Enter Customer id"); 
							 *  */
							int cid;
							
							try {
									log.info("Enter Email");
									String email = sc.next();
									log.info("Enter Password");
									String pwd = sc.next();
									if (cusSer.checkEmailAvailability(email)) {
										if (val.emailValidation(email)) {
											if (val.passwordValidtion(pwd)) {
												UserInfoBean bean = new UserInfoBean();
												cid = CollectionDbClass.customerSet.size()+1;
												bean.setId(cid);
												bean.setPassword(pwd);
												bean.setEmail(email);
												if(CollectionDbClass.customerSet.add(bean)) {
													log.info("Registered Successfully");
												} else {
													log.info("Registration Failed");
												}
											} else {
												System.err.println("Password Must contains more than 4 letters");
											}
										} else {
											System.err.println("Please Enter Valid Email");
										}
									} else {
										try {
											throw new EmailAlreadyExistsException();
										} catch (EmailAlreadyExistsException e) {
											System.err.println(e.getMessage());
										}
									}
							} catch (InputMismatchException e) {
								try {
									throw new EnterValidInputException();
								} catch (EnterValidInputException exp) {
									log.info(exp.getMessage());
									break;
								}
							}
						} else if (ch == 2) {
							log.info("Enter Customer email");
							String email = sc.next();
							log.info("Enter Password");
							password = sc.next();
							if (val.passwordValidtion(password)) {
								UserInfoBean customer = cusSer.login(email, password);
								if (customer != null) {
									log.info("Customer Login Successful");
									CustomerController controller = new CustomerController();
									customer.setRole("customer");
									controller.customer(customer);
								} else {
									log.info("Customer Doesnt exists");
								}
							} else {
								System.err.println("Password Must contains more than 4 letters");
							}
						} else {
							log.info("Enter valid choice");
						}
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							System.err.println(exp.getMessage());
						}
					}
					break;
				case 5:
					log.info("Thank you for using the app");
					System.exit(0);
				default:
					log.info("Invalid Choice");
				}
			} catch (InputMismatchException e) {
				try {
					throw new EnterValidInputException();
				} catch (EnterValidInputException exp) {
					System.err.println(exp.getMessage());
					start();
				}
			}
		}
		sc.close();
	}
}
