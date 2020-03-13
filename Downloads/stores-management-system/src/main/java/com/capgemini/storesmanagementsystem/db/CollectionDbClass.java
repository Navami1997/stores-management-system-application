package com.capgemini.storesmanagementsystem.db;

import java.util.HashSet;
import java.util.LinkedHashSet;

import com.capgemini.storesmanagementsystem.dto.ProductInfoBean;
import com.capgemini.storesmanagementsystem.dto.UserInfoBean;

public class CollectionDbClass {
	public static final HashSet<UserInfoBean> userSet = new LinkedHashSet<UserInfoBean>();
	public static final HashSet<ProductInfoBean> productSet = new LinkedHashSet<ProductInfoBean>();
	public static final HashSet<UserInfoBean> dealerSet = new LinkedHashSet<UserInfoBean>();
	public static final HashSet<UserInfoBean> manufacturerSet = new LinkedHashSet<UserInfoBean>();
	public static final  HashSet<UserInfoBean> customerSet = new LinkedHashSet<UserInfoBean>();
}
