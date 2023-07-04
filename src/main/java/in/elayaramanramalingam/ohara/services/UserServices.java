package in.elayaramanramalingam.ohara.services;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.validation.UserValidator;
import in.elayaramanramalingam.ohara.dao.UserDAO;

public class UserServices {

	public User[] getAll() {

		UserDAO userDAO = new UserDAO();

		User[] userList = userDAO.findAll();

		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}

		return userList;

	}
	
	/**
	 * Create a new user Object
	 * @param user userObject
	 * @throws Exception 
	 */
	public void create(User user) throws Exception {
		
		UserValidator.validate(user);
		UserDAO userDAO = new UserDAO();
		userDAO.create(user);
		
	
	}
	
	public void update(int id, User user) {
		UserDAO userDAO = new UserDAO();
		userDAO.update(id, user);
	}

}
