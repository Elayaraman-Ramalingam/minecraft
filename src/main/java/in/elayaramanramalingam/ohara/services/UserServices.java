package in.elayaramanramalingam.ohara.services;

import in.elayaramanramalingam.ohara.model.User;

import in.elayaramanramalingam.ohara.dao.UserDAO;

import java.util.Arrays;


public class UserServices {
	
	public User[] getAll() {
		
		UserDAO userDAO = new UserDAO();
		
		User[] userList =  userDAO.findAll();
		
		System.out.println(userList);
		for(int i =0; i < userList.length;i++) {
			System.out.println(userList[i]);
		}
		
		return userList;
		
	}

}
