package com.capgemini.storesmanagementsystem.controller;

import org.apache.log4j.Logger;

public class Application {
	static Logger log = Logger.getLogger(Application.class);
	public static void main(String[] args) {
		log.info("\t \t ===============================================================\t \t");
		log.info("\t \t ||                                                           ||");
		log.info("\t \t || \t Welcome to Stores Management System Appication       ||");
		log.info("\t \t ||                                                           ||");
		log.info("\t \t ===============================================================\t \t");
		log.info("===================================================================="
				+ "==========================================================");
		StoresManagementApp.start();
	}
}
