package in.elayaramanramalingam.ohara;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;

public class TestCreateUser {

	@Test
	public void testCreateUserWithValidInput() {

		UserServices userServices = new UserServices();

		User user = new User();

		user.setId(124);
		user.setfName("Elaya");
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd("P@$$w0rD");
		user.setStatus(true);
		assertDoesNotThrow(() -> {
			userServices.create(user);
		});

	}

	@Test
	public void testCreateUserWithInvalidInput() throws Exception {
		UserServices userServices = new UserServices();
		Exception exception = assertThrows(Exception.class, () -> {
			userServices.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String receivedMessage = exception.getMessage();
		
		assertTrue(exceptedMessage.equals(receivedMessage));
	}
	@Test
	public void testCreateUserWithEmailNull() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setId(124);
		user.setfName("Elaya");
		user.setEmail(null);
		user.setPhone(9344048138l);
		user.setPasswd("P@$$w0rD");
		user.setStatus(true);
		assertDoesNotThrow(() -> {
			userServices.create(user);
		});

		Exception exception = assertThrows(Exception.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Email cannot be empty or null";
		String receivedMessage = exception.getMessage();
		
		assertTrue(exceptedMessage.equals(receivedMessage));
	}
	public void testCreateUserWithEmailEmpty() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setId(124);
		user.setfName("Elaya");
		user.setEmail("");
		user.setPhone(9344048138l);
		user.setPasswd("P@$$w0rD");
		user.setStatus(true);
		assertDoesNotThrow(() -> {
			userServices.create(user);
		});

		Exception exception = assertThrows(Exception.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Email cannot be empty or null";
		String receivedMessage = exception.getMessage();
		
		assertTrue(exceptedMessage.equals(receivedMessage));
	}
}