package in.elayaramanramalingam.ohara.dao;

import in.elayaramanramalingam.ohara.model.User;

public class UserDAO {
	
	public User[] findAll() {
		
		User[] users = UserList.listOfUsers ;
		return users;
	}
	
	public void create() {
		
		User user =  new User();
		
		user.setId(124);
		user.setfName("Elaya");
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd("P@$$w0rD");
		user.setStatus(true);
		
		UserList.listOfUsers[0] = user;
		return ;
		
	}

}
