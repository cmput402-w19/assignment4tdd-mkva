package markos.messageBoard;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserManagementTest {

	@Test
	public void testUserLoginUsername() throws Exception {
		String username = "usernamefoo";
		String password = "pass";
		UserManagement userManag = new UserManagement();
		User currentUser = userManag.userLogin();
		assert(currentUser.getUsername().equals("usernamefoo"));
	}

}
