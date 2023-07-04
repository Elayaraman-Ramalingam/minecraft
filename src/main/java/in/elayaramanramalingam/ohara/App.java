package in.elayaramanramalingam.ohara;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;
import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.services.TaskServices;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			UserServices userServices = new UserServices();

			User user = new User();

			user.setId(124);
			user.setfName("Elaya");
			user.setEmail("mmm");
			user.setPhone(9344048138l);
			user.setPasswd("P@$$w0rD");
			user.setStatus(true);

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
			task.setId(007);
			task.setName(null);
			task.setDue(2);
			task.setStatus(true);
			taskservices.create(task);
			taskservices.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
