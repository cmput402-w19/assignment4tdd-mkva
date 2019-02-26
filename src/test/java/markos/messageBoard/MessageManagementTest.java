package markos.messageBoard;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	@Test
	public void testviewMessages() throws Exception {
		MessageManagement messManag = new MessageManagement();
		messManag.viewMessages(new User("markosva", "markos", "markos@email.com"));
		
		String data = "ret";
		InputStream stdin = System.in;
		try {
		  System.setIn(new ByteArrayInputStream(data.getBytes()));
		  Scanner scanner = new Scanner(System.in);
		  System.out.println(scanner.nextLine());
		} finally {
		  System.setIn(stdin);
		}
		
		
	}

}
