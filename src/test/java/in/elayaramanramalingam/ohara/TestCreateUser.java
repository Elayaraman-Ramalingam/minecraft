package in.elayaramanramalingam.ohara;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;
import in.elayaramanramalingam.ohara.exception.ValidationException;

public class TestCreateUser {

	@Test
	public void testCreateUserWithValidInput() {

		UserServices userServices = new UserServices();

		User user = new User();

		user.setFirstName("Elaya");
		user.setLastName("SenPai");
		user.setEmail("1241@google.com");
		user.setPassword("P@$$w0rD");
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
		user.setFirstName("Elaya");
		user.setLastName("SenPai");
		user.setEmail(null);
		user.setPassword("P@$$w0rD");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Email cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}

	@Test
	public void testCreateUserWithEmailEmpty() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setFirstName("Elaya");
		user.setLastName("SenPai");
		user.setEmail("");
		user.setPassword("P@$$w0rD");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Email cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}

	@Test
	public void testCreateUserWithPasswordNull() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setFirstName("Elaya");
		user.setLastName("SenPai");
		user.setEmail("1241@google.com");
		user.setPassword(null);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "password cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}

	@Test
	public void testCreateUserWithPasswordEmpty() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setFirstName("Elaya");
		user.setLastName("SenPai");
		user.setEmail("124@google.com");
		user.setPassword("");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "password cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}

	@Test
	public void testCreateUserWithFirstnameNull() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setFirstName(null);
		user.setEmail("1241@google.com");
		user.setPassword("password");
		user.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Firstname cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}

	@Test
	public void testCreateUserWithFirstnameEmpty() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setFirstName("");
		user.setEmail("124@google.com");
		user.setPassword("password");
		user.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Firstname cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}

	@Test
	public void testCreateUserWithSecondnameNull() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setFirstName("First");
		user.setLastName(null);
		user.setEmail("1241@google.com");
		user.setPassword("password");
		user.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Secondname cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}

	@Test
	public void testCreateUserWithSecondnameEmpty() throws Exception {
		UserServices userServices = new UserServices();
		User user = new User();

		user.setFirstName("First");
		user.setLastName("");
		user.setEmail("1241@google.com");
		user.setPassword("password");
		user.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Secondname cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}
//	@Test
//	public void testCreateUserWithDupicateEmail() throws Exception {
//		UserServices userservices = new UserServices();
//		
//		User user = new User();
//		
//		user.setFirstName("First");
//		user.setLastName("Last");
//		user.setEmail("1241@google.com");
//		user.setPassword("password");
//		
//		Exception exception = assertThrows(SQLException.class , ()->{
//			userservices.create(user);
//		});
//		
//		String exceptedMessage = "Duplicate";
//		String receivedMessage = exception.getMessage();
//		
//		System.out.println(receivedMessage);
//		
//		assertTrue(receivedMessage.contains(exceptedMessage));
//	}

}
