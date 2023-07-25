package in.elayaramanramalingam.ohara;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;

import java.time.LocalDate;

import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.services.TaskServices;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			UserServices userServices = new UserServices();

			User user = new User();

			user.setFirstName("Elaya");
			user.setLastName("jksbkjsbkjvb");
			user.setEmail("mmm");
			user.setPassword("P@$$w0rD");

			userServices.create(user);
			userServices.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			TaskServices taskservices = new TaskServices();

			Task task = new Task();
			
			task.setName("Name");
			LocalDate date = LocalDate.of(2023, 12, 8);
			task.setDueDate(date);
			task.setActive(true);
			taskservices.create(task);
			taskservices.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e);
		}
	}

}
