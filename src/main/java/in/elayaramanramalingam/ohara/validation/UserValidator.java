package in.elayaramanramalingam.ohara.validation;

import in.elayaramanramalingam.ohara.Util.StringUtil;
import in.elayaramanramalingam.ohara.exception.ValidationException;
import in.elayaramanramalingam.ohara.model.User;

public class UserValidator {

	public static void validate(User user) throws ValidationException {
		
		if(user == null) {
			throw new ValidationException("Invalid user input");
		}
//		if(user.getEmail() == null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("Email cannot be empty or null");
//		}
//		if(user.getPasswd() ==  null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("Password cannot be empty or null");
//		}
//		if(user.getfName()==null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("First name cannot be empty or null");
//		}
		StringUtil.rejectIfInvalidString(user.getEmail(),"Email");
		StringUtil.rejectIfInvalidString(user.getPasswd(),"password");
		StringUtil.rejectIfInvalidString(user.getfName(),"Firstname");
		
	}
}
