package in.elayaramanramalingam.ohara.services;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.validation.UserValidator;

import java.util.Set;

import in.elayaramanramalingam.ohara.dao.UserDAO;

public class UserServices {

	public Set<User> getAll() {

	    UserDAO userDAO = new UserDAO();

	    Set<User> userList = userDAO.findAll();

	    for (User user : userList) {
	        System.out.println(user);
	    }

	    return userList;
	}


	public void create(User user) throws Exception {

		UserValidator.validate(user);
		UserDAO userDAO = new UserDAO();
		userDAO.create(user);

	}

	public void update(int id, User user) {
		UserDAO userDAO = new UserDAO();
		userDAO.update(id, user);
	}

	public void delete(int id) {
		UserDAO userDAO = new UserDAO();
		userDAO.delete(id);
	}

	public void findById(int id) {
		UserDAO userDAO = new UserDAO();
		userDAO.findById(id);
	}

}
