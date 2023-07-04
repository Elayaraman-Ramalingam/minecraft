package in.elayaramanramalingam.ohara.validation;


import in.elayaramanramalingam.ohara.exception.ValidationException;
import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.Util.StringUtil;

public class TaskValidator {
	
	public static void validate(Task task) throws ValidationException{
		if(task == null) {
			throw new ValidationException("Invalid user input");
		}
		
		StringUtil.rejectIfInvalidString(task.getName(), "Name");
	}

}
