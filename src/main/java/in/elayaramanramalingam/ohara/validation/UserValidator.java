package in.elayaramanramalingam.ohara.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.elayaramanramalingam.ohara.Util.StringUtil;
import in.elayaramanramalingam.ohara.exception.ValidationException;
import in.elayaramanramalingam.ohara.model.User;

public class UserValidator {
	
	static void rejectIfInvalidEmail(String email) throws ValidationException {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new ValidationException("Invalid email format: " + email);
        }
    }
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
		rejectIfInvalidEmail(user.getEmail());
		StringUtil.rejectIfInvalidString(user.getPassword(),"password");
		StringUtil.rejectIfInvalidString(user.getFirstName(),"Firstname");
		StringUtil.rejectIfInvalidString(user.getLastName(),"Secondname");
		
	}
}
