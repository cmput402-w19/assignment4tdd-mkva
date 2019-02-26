package markos.messageBoard;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import services.MessageInfo;
import services.UserInfo;

public class MessageManagementTest {

	@Test
	public void testFilterUsers() throws Exception {
		MessageManagement messManag = new MessageManagement();
		MessageInfo messMock = mock(MessageInfo.class); 

		// create messages
		List<Message> listMessagesAll = new ArrayList<Message>();
		Message m1 = new Message(1, "type 1 message", "markos", "2019");
		Message m2 = new Message(2, "type 2 message", "markos2", "20192");
		
		listMessagesAll.add(m1);
		listMessagesAll.add(m2);
		
		when(messMock.listAllMessages()).thenReturn(listMessagesAll);
		messManag.filterMessagesAndDisplay(messMock);

		assert(1 == messManag.getFilter());
		verify(messMock, times(1)).listAllMessages();
	}

}
