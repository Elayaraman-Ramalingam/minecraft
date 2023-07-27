package in.elayaramanramalingam.ohara;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;

public class TestGetAllUsers {
	
	@Test
	public void testGetAllUsers() {
		UserServices userser = new UserServices();
		
		List<User> users = userser.getAll();
		
		System.out.println(users);
	}
	
	@Test
	public void testFindById() {
		UserServices userser = new UserServices();
		
		User user = userser.findById(1);
		
		System.out.println(user);
	}

}
