package in.elayaramanramalingam.ohara;

import in.elayaramanramalingam.ohara.model.User;
import in.elayaramanramalingam.ohara.services.UserServices;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			
			UserServices userServices = new UserServices();
			
			User user =  new User();
			
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
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		


	}

}
