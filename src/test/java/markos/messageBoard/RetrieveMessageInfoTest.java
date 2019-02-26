package markos.messageBoard;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import db.DAOAccess;
import services.MessageInfo;

public class RetrieveMessageInfoTest {

	@Test
	public void testListAllMessages() throws Exception {
		RetrieveMessageInfo messManag = new RetrieveMessageInfo();

		assertEquals(messManag.listAllMessages().getClass(), ArrayList.class);
	}

}
