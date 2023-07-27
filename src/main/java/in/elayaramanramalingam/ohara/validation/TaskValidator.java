package in.elayaramanramalingam.ohara.validation;


import in.elayaramanramalingam.ohara.exception.ValidationException;
import in.elayaramanramalingam.ohara.model.Task;

import java.sql.Date;
import java.time.*;

import in.elayaramanramalingam.ohara.Util.StringUtil;

public class TaskValidator {
	
	public static void validate(Task task) throws ValidationException{
		if(task == null) {
			throw new ValidationException("Invalid user input");
		}
		if(task.getDueDate() == null) {
			throw new ValidationException("Date cannot be null or empty");
		}
		if (task.getDueDate().before(Date.valueOf(LocalDate.now()))) {
		    throw new ValidationException("Task cannot be assigned to the past");
		}

		
		StringUtil.rejectIfInvalidString(task.getName(), "Name");
	}

}
