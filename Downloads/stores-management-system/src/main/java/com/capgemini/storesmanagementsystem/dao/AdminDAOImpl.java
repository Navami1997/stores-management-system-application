package com.capgemini.storesmanagementsystem.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.capgemini.storesmanagementsystem.db.CollectionDbClass;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public boolean addManufacturer(UserInfoBean manufacturer) {
		return CollectionDbClass.manufacturerSet.add(manufacturer);
		
	}

	@Override
	public UserInfoBean updateManufacturerDetails(UserInfoBean manufacturer) {

		Iterator<UserInfoBean> itr = CollectionDbClass.manufacturerSet.iterator();
		while (itr.hasNext()) {
			UserInfoBean found = itr.next();
			if (found.getId() == manufacturer.getId()) {
				found.setPassword(manufacturer.getPassword());
				found.setUserName(manufacturer.getUserName());
				return found;
			}
		}
		return null;
	}

	@Override
	public UserInfoBean getManufacturerDetails(int id) {
		for (UserInfoBean man : CollectionDbClass.manufacturerSet) {
			if (man.getId() == id) {
				return man;
			}
		}
		return null;
	}

	@Override
	public List<UserInfoBean> getAllManufacturersDetails() {
		return new ArrayList<UserInfoBean>(CollectionDbClass.manufacturerSet);
	}

	

	@Override
	public boolean removeManufacturer(int id) {
		Set<UserInfoBean> manufacturer = CollectionDbClass.manufacturerSet;
		for (UserInfoBean manu : manufacturer) {
			if (manu.getId() == id) {
				manufacturer.remove(manu);
				return true;
			}
		}
		return false;
	}

}
