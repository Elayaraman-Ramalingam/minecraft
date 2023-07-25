package in.elayaramanramalingam.ohara;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;
import in.elayaramanramalingam.ohara.exception.ValidationException;

public class TestCreateUser {

//	@Test
//	public void testCreateUserWithValidInput() {
//
//		UserServices userServices = new UserServices();
//
//		User user = new User();
//
//		user.setId(124);
//		user.setfName("Elaya");
//		user.setEmail("124@google.com");
//		user.setPhone(9344048138l);
//		user.setPasswd("P@$$w0rD");
//		user.setStatus(true);
////		assertDoesNotThrow(() -> {
////			userServices.create(user);
////		});
//
//	}

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

		user.setId(124);
		user.setfName("Elaya");
		user.setEmail("");
		user.setPhone(9344048138l);
		user.setPasswd("P@$$w0rD");
		user.setStatus(true);

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

		user.setId(124);
		user.setfName("Elaya");
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd(null);
		user.setStatus(true);

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

		user.setId(124);
		user.setfName("Elaya");
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd("");
		user.setStatus(true);

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

		user.setId(124);
		user.setfName(null);
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd("password");
		user.setStatus(true);

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

		user.setId(124);
		user.setfName("");
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd("password");
		user.setStatus(true);

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

		user.setId(124);
		user.setfName("First");
		user.setsName(null);
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd("password");
		user.setStatus(true);

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

		user.setId(124);
		user.setfName("First");
		user.setsName("");
		user.setEmail("124@google.com");
		user.setPhone(9344048138l);
		user.setPasswd("password");
		user.setStatus(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userServices.create(user);
		});
		String exceptedMessage = "Secondname cannot be empty or null";
		String receivedMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(receivedMessage));
	}
}
