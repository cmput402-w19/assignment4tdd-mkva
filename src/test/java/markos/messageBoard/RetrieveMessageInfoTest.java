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
//		RetrieveMessageInfo messManag = new RetrieveMessageInfo();
//		DAOAccess messMock = mock(DAOAccess.class); 
//
//		// create results
//		List<Message> listAllMessages = new ArrayList<Message>();
//		Message m1 = new Message(1, "type 1 message", "markos", "2019");
//		Message m2 = new Message(2, "type 2 message", "markos2", "20192");
//		
//		listAllMessages.add(m1);
//		listAllMessages.add(m2);
//		
//		ResultSet resultSetMock = mock(ResultSet.class); 
//
//		when(messMock.getListMessages()).thenReturn(resultSetMock);
//		
//
//		assertEquals(messManag.listAllMessages().getClass(), List.class);
//		verify(messMock, times(1)).getListMessages();
	}

}
