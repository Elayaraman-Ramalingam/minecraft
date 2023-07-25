package in.elayaramanramalingam.ohara.dao;

import java.util.HashSet;
import java.util.Set;

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
			String query = "SELECT * FROM users WHERE is_active = 1 ";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(connection, ps, rs);
		}
		return users;
	}

	public void create(User user) {

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO users(first_name,second_name,email,password)values(?,?,?,?)";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1,user.getFirstName());
			ps.setString(2,user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4,user.getPassword());
			ps.executeUpdate();
			System.out.println("User created");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(connection, ps);
		}

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
		User user = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM users WHERE is_active = 1 AND id = ? ";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(connection, ps, rs);
		}

		return user;
	}
}
