package com.capgemini.storesmanagementsystem.dao;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public interface AdminDAO {
	public boolean addManufacturer(UserInfoBean manufacturer);
	public UserInfoBean updateManufacturerDetails(UserInfoBean manufacturer);
	public UserInfoBean getManufacturerDetails(int id);
	public List<UserInfoBean> getAllManufacturersDetails();
	public boolean removeManufacturer(int id);
}
