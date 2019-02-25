package markos.messageBoard;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	//TEST CASES FOR USERNAME VALIDITY
	@Test
	public void testValidUsername() throws Exception {
		User user = new User("usernamefoo", "My Namefoo", "MyEmailfoo@email.com");
		assertTrue(user.validUsername("usernamefoo"));
	}

}
