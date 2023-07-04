package in.elayaramanramalingam.ohara.dao;

import in.elayaramanramalingam.ohara.model.User;

public class UserDAO {

	public User[] findAll() {

		User[] users = UserList.listOfUsers;
		return users;
	}

	public void create(User user) {
		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {
			User index = arr[i];
			if (index == null) {
				arr[i] = user;
				break;
			}
		}
		return;
	}

	public void update(int id, User user) {
		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {
			User index = UserList.listOfUsers[i];
			if (index == null) {
				continue;
			}
			if (index.getId() == id) {
				arr[i] = user;
				break;
			}
		}
	}

	public void delete(int UserID) {
		User[] userList = UserList.listOfUsers;

		for (int i = 0; i < userList.length; i++) {
			User index = userList[i];
			if (index.getId() == UserID) {
				index.setStatus(false);
				break;
			}
		}
	}

	public void findById(int Id) {
		User[] userList = UserList.listOfUsers;
		for (int i = 0; i < userList.length; i++) {
			User index = userList[i];
			if (index.getId() == Id) {
				
				return;
			}
		}
	}

}
