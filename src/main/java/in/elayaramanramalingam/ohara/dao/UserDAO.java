package in.elayaramanramalingam.ohara.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.elayaramanramalingam.ohara.Util.ConnectionUtil;
import in.elayaramanramalingam.ohara.model.User;

public class UserDAO {

	public List<User> findAll() {

		List<User> users = new ArrayList<>();

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
			if(e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("Duplicate constraint");
			} else {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
		}finally {
			ConnectionUtil.close(connection, ps);
		}

	}

	public void update(int id, User user) {
	    Connection connection = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE users SET first_name=?, second_name=? WHERE id=?";
	        connection = ConnectionUtil.getConnection();
	        ps = connection.prepareStatement(query);
	        ps.setString(1, user.getFirstName());
	        ps.setString(2, user.getLastName());
	        ps.setInt(3, id);
	        int rowsUpdated = ps.executeUpdate();

	        if (rowsUpdated > 0) {
	            System.out.println("User with ID " + id + " updated successfully.");
	        } else {
	            System.out.println("No user found with ID " + id + ". Update failed.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    } finally {
	        ConnectionUtil.close(connection, ps);
	    }
	}


	public void delete(int userId) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE users SET is_active = 0 AND id = ? ";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(connection, ps);
		}
//		Set<User> userList = UserList.listOfUsers;
//		for (User user : userList) {
//			if (user.getId() == userId) {
//				user.setActive(false);
//				break;
//			}
//		}
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
	public User findByEmail(String Email) {
		User user = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM users WHERE is_active = 1 AND email = ? ";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, Email);
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
