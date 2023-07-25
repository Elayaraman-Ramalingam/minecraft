package in.elayaramanramalingam.ohara.dao;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.elayaramanramalingam.ohara.Util.ConnectionUtil;
import in.elayaramanramalingam.ohara.model.User;

public class UserDAO {

	public Set<User> findAll() {

		Set<User> users = new HashSet<>();

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM USERS WHERE isActive = 1 ";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getLong("phone"));
				user.setActive(rs.getBoolean("isActive"));

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(connection, ps, rs);
		}
		return users;
	}

	public void create(User user) {
		Set<User> arr = UserList.listOfUsers;
		arr.add(user);
	}

	public void update(int id, User user) {
		Set<User> arr = UserList.listOfUsers;
		for (User index : arr) {
			if (index.getId() == id) {
				arr.remove(index);
				arr.add(user);
				break;
			}
		}
	}

	public void delete(int userId) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user.getId() == userId) {
				user.setActive(false);
				break;
			}
		}
	}

	public User findById(int id) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
