package markos.messageBoard;

import services.UserInfo;

public class UserManagement {

	private int filter;
	
	public User userLogin() throws Exception {
		User user = new User("usernamefoo", "nameX", "usernamefoo@email.com");
		return user;
		
	}
	
	public User userRegister() {
		return null;
		
	}

	public void filterUsersAndDisplay(UserInfo userInfo) {

	}
	
	public int getFilter() {
		return (Integer) null;
	}
}
