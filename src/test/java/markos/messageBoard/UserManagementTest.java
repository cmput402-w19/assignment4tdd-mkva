package markos.messageBoard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import services.UserInfo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class UserManagementTest {

	@Test
	public void testUserLoginUsername() throws Exception {
		String username = "usernamefoo";
		UserManagement userManag = new UserManagement();
		User currentUser = userManag.userLogin();
		assert(currentUser.getUsername().equals("usernamefoo"));
	}

	@Test
	public void testFilterUsers() throws Exception {
		UserManagement userManag = new UserManagement();
		UserInfo userMock = mock(UserInfo.class); 

		// create users
		List<User> listUsersAll = new ArrayList<User>();
		User u1 = new User("username1", "name1", 0);
		User u2 = new User("username2", "name2", 2);
		listUsersAll.add(u1);
		listUsersAll.add(u2);

		when(userMock.listUsers()).thenReturn(listUsersAll);
		userManag.filterUsersAndDisplay(userMock);

		assert(1 == userManag.getFilter());
		verify(userMock, times(1)).listUsers();
	}

}
