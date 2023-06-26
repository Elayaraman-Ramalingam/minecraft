package in.elayaramanramalingam.ohara;

import in.elayaramanramalingam.ohara.services.UserServices;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserServices userServices = new UserServices();
		
		userServices.getAll();

	}

}
