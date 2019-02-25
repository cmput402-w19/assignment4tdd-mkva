package markos.messageBoard;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MessageTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testValidContent() throws Exception {
		Message post = new Message(1, "This is a post content", "markosva", "2019-02-21");
		assertTrue(post.validContent("This is a post content"));
	}

	@Test
	public void testValidContentEmpty() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Invalid post! Posts must have a content.");
		Message post = new Message(1, "", "markosva", "2019-02-21");
	}

	@Test
	public void testValidContentWhiteSpaces() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Invalid post! Posts must not be composed only of white spaces.");
		Message post = new Message(1, "    ", "markosva", "2019-02-21");
	}
}
