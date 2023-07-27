package in.elayaramanramalingam.ohara;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;

import java.time.LocalDate;

import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.services.TaskServices;

public class App {

	public static void main(String[] args) {

		try {
			UserServices userser = new UserServices();
			
			User user = userser.findById(1);
			
			System.out.println(user);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			TaskServices taskservices = new TaskServices();

			taskservices.getAll();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
