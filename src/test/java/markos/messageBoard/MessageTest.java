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
}
