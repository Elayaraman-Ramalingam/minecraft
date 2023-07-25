package in.elayaramanramalingam.ohara.Interface;

import in.elayaramanramalingam.ohara.model.User;

public interface UserInterface extends Base<User> {
	
	public abstract User findByEmailId(String email);
	
	public abstract int count();

}
