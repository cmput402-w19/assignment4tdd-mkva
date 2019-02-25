package markos.messageBoard;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserManagementTest {

	@Test
	public void testUserLoginUsername() throws Exception {
		String username = "usernamefoo";
		UserManagement userManag = new UserManagement();
		User currentUser = userManag.userLogin();
		assert(currentUser.getUsername().equals("usernamefoo"));
	}

}
