package com.capgemini.storesmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dto.UserInfoBean;
import com.capgemini.storesmanagementsystem.exception.EnterValidInputException;
import com.capgemini.storesmanagementsystem.exception.IdAlreadyExistsException;
import com.capgemini.storesmanagementsystem.exception.NameAlreadyExistsException;
import com.capgemini.storesmanagementsystem.service.FactoryClass;
import com.capgemini.storesmanagementsystem.service.StoresManagementSystem;
import com.capgemini.storesmanagementsystem.validation.Validations;

public class AdminController {
	static Logger log = Logger.getLogger(AdminController.class);
	Scanner sc = new Scanner(System.in);
	
	Validations val = new Validations();
	boolean adminFlag = true;

	public void admin(UserInfoBean admin) {
		log.info("Welcome Admin");
		StoresManagementSystem adminSer = FactoryClass.getService(admin);
		UserInfoBean user = new UserInfoBean();
		user.setRole("manufacturer");
		StoresManagementSystem manSer = FactoryClass.getService(user);
		while (adminFlag) {
			log.info("Operation you would like to perform ?");
			log.info(" 1. Add Manufacturer \n " + "2. Update Manufacturer Details \n "
					+ "3. Get Manufacturer Details \n " + "4. Get All Manufacturers Details \n " + "5. Delete Manufacturer \n" + " 6. Exit as Admin");
			log.info("Enter Your Choice");
			log.info("===================================================================="
					+ "==========================================================");
			try {
				int adminChoice = sc.nextInt();
				switch (adminChoice) {
				case 1:
					UserInfoBean manufacturer = new UserInfoBean();
					log.info("Enter Manufacturer Name");
					sc.nextLine();
					String name = sc.nextLine();
					if(manSer.checkNameAvailability(name)) {
					if (val.nameValidation(name)) {
						manufacturer.setUserName(name);
						log.info("Enter Password for Manufacturer");
						String password = sc.next();
						manufacturer.setPassword(password);
						if (val.passwordValidtion(password)) {
							log.info("Enter Manufacturer Id");
							int manId=sc.nextInt();
							if(manSer.checkIdAvailability(manId)) {
							manufacturer.setId(manId);
							if (adminSer.addManufacturer(manufacturer)) {
								log.info("Manufacturer Added Successfully");
							} else {
								log.info("Adding Manufacturer Failed");
							}
							} else {
								try {
									throw new IdAlreadyExistsException();
								} catch(IdAlreadyExistsException exp) {
									System.err.println(exp.getMessage());
									break;
								}
							}
						} else {
							log.info("Password Must contain more than four letters");
						}
					} else {
						log.info("Please enter valid Name");
					}
					} else {
						try {
							throw new NameAlreadyExistsException();
						} catch (NameAlreadyExistsException e) {
							System.err.println(e.getMessage());
							break;
						}
					}
					break;
				case 3:
					log.info("Enter Manufacturer Id");

					int manId;
					try {
						manId = sc.nextInt();
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							System.err.println(exp.getMessage());
							break;
						}
					}
					UserInfoBean man = adminSer.getManufacturerDetails(manId);
					if (man != null) {
						log.info("===================================================================="
								+ "==========================================================");
						log.info(" ManufacturerName = " + man.getUserName());
					} else {
						log.info("Manufacturer Not found");
					}
					break;
				case 2:
					UserInfoBean bean = new UserInfoBean();
					log.info("Enter Id to Update");
					try {
						bean.setId(sc.nextInt());
					} catch (InputMismatchException e) {
						try {
							throw new EnterValidInputException();
						} catch (EnterValidInputException exp) {
							System.err.println(exp.getMessage());
							break;
						}
					}
					log.info("Enter New Name for Manufacturer");
					sc.nextLine();
					String newName = sc.nextLine();
					if(manSer.checkNameAvailability(newName)) {
					if (val.nameValidation(newName)) {
						bean.setUserName(newName);
						log.info("Enter new Password");
						bean.setPassword(sc.next());
						if (adminSer.updateManufacturerDetails(bean) != null) {
							log.info("Updated Successfully");
						} else {
							log.info("Updation Failed");
						}
					} else {
						log.info("Enter valid name");
					}
					} else {
						try {
							throw new NameAlreadyExistsException();
						} catch (NameAlreadyExistsException e) {
							System.err.println(e.getMessage());
						}
					}
					break;
				case 4:
					log.info("===================================================================="
							+ "==========================================================");
					List<UserInfoBean> manufacturers = adminSer.getAllManufacturersDetails();
					if (manufacturers != null) {
						Iterator<UserInfoBean> itr = manufacturers.iterator();
						while (itr.hasNext()) {
							UserInfoBean mans = itr.next();
							log.info(" ManufacturerName = " + mans.getUserName() 
									+ " \t MId = " + mans.getId());
						}
						log.info("===================================================================="
								+ "==========================================================");
					} else {
						log.info("There are no manufacturers");
					}
					break;
				case 5:
					log.info("=========================================================================");
					UserInfoBean mib = new UserInfoBean();
					log.info("Enter the Manufacturer Id whose details you want to delete");
					int id = sc.nextInt();
					if(adminSer.removeManufacturer(id)) {
						log.info("Manufacturer deleted successfully");
					}else {
						log.info("Deleting Manufacturer Failed..!!");
					}
					break;
				case 6:
					adminFlag = false;
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
			if (adminFlag == false)
				break;
		}
	}
}
