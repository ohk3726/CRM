package com.usinsa.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usinsa.crm.dao.UserDAO;

@Service("User_Service")
public class User_ServiceImpl implements User_Service{

	@Autowired
	private UserDAO UserMapper;
	

	@Override
	@Transactional
	public List Level_List() throws Exception {

		return UserMapper.Level_List();
	}
	
	
}
