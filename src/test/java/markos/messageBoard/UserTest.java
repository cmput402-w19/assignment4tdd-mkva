package markos.messageBoard;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserTest {
	//TEST CASES FOR USERNAME VALIDITY
	@Test
	public void testValidUsername() throws Exception {
		User user = new User("usernamefoo", "My Namefoo", "MyEmailfoo@email.com");
		assertTrue(user.validUsername("usernamefoo"));
	}

	// boundary test - size = 0 (error)
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testValidUsernameSizeZero() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Invalid username! Usernames cannot be empty.");
		User user = new User("", "My Namefoo", "MyEmailfoo@email.com");
	}

	// boundary test - size = > 0 and content = special characters
	@Test
	public void testValidUsernameSpecialCharacters() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Invalid username! Usernames cannot have special characters.");
		User user = new User("username!#", "My Namefoo", "MyEmailfoo@email.com");
	}

	// boundary test - size = > 0 and content = white space
	@Test
	public void testValidUsernameWhiteSpace() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Invalid username! Usernames cannot have white space.");
		User user = new User("username foo", "My Namefoo", "MyEmailfoo@email.com");
	}

	//TEST CASES FOR EMAIL VALIDITY
	@Test
	public void testValidEmail() throws Exception {
		User user = new User("username123", "My Namefoo", "MyEmailfoo@email.com");
		assertTrue(user.validEmail("MyEmailfoo@email.com"));
	}

}
