package in.elayaramanramalingam.ohara;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.TaskServices;
import in.elayaramanramalingam.ohara.services.UserServices;

public class TestGetAllTasks {
	
	@Test
	public void testGetAllTasks() {
		TaskServices userser = new TaskServices();
		
		List<Task> users = userser.getAll();
		
		System.out.println(users);
	}
	
	@Test
	public void testFindById() {
		TaskServices userser = new TaskServices();
		
		Task user = userser.findById(1);
		
		System.out.println(user);
	}

}
