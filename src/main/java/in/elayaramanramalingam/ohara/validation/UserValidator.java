package in.elayaramanramalingam.ohara.validation;

import in.elayaramanramalingam.ohara.model.User;

public class UserValidator {

	public static void validate(User user) throws Exception {
		
		if(user == null) {
			throw new Exception("Invalid user input");
		}
		if(user.getEmail() == null || "".equals(user.getEmail().trim())) {
			throw new Exception("Email cannot be empty or null");
		}
		if(user.getPasswd() ==  null || "".equals(user.getEmail().trim())) {
			throw new Exception("Password connot be empty or null");
		}
		if(user.getfName()==null || "".equals(user.getEmail().trim())) {
			throw new Exception("First name cannot be empty or null");
		}
		
	}
}
