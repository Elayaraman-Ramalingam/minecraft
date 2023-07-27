package in.elayaramanramalingam.ohara.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.*;

import in.elayaramanramalingam.ohara.Util.ConnectionUtil;
import in.elayaramanramalingam.ohara.model.Task;

public class TaskDAO {

    List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Task> tasks = new ArrayList<>();

		try {
			String query = "SELECT * FROM tasks WHERE is_active = 1 ";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDueDate(""+rs.getDate("due_date"));
				task.setActive(rs.getBoolean("is_active"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(connection, ps, rs);
		}
		return tasks;
    }

    public void create(Task task) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            String query = "INSERT INTO tasks (name, due_date) VALUES (?, ?)";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, task.getName());

            ps.setDate(2, task.getDueDate());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Task has been created successfully");
            } else {
                System.out.println("Failed to create task");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating the task: " + e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps);
        }
    }

    public void update(int id, Task task) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE tasks SET name = ?, due_date = ? WHERE id = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, task.getName());

            ps.setObject(2, task.getDueDate());

            ps.setInt(3, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Task with ID " + id + " has been updated successfully");
            } else {
                System.out.println("Failed to update task with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating the task: " + e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps);
        }
    }

    public void delete(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE tasks SET is_active = 0 WHERE id = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Task with ID " + id + " has been deleted successfully");
            } else {
                System.out.println("Failed to delete task with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps);
        }
    }


    public Task findById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM tasks WHERE id = ? AND is_active = 1";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setDueDate(rs.getString("due_date"));
                task.setActive(rs.getBoolean("is_active"));
                return task;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException( e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }
        return null; // If no task found with the given ID
    }

}
