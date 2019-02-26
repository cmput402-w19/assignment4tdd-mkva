package markos.messageBoard;

import java.util.Scanner;

import db.DAOAccess;
import services.MessageInfo;

public class MessageManagement {

	DAOAccess db = new DAOAccess();
	Scanner option = new Scanner(System.in);
	private int filter;

	public void viewMessages(User currentUser)  {

	}
	
	private void postNewMessageAnswer(User currentUser, int parent)  {

	}

	private void postNewMessage(User currentUser) {

	}

	public void displayAllMessages(RetrieveMessageInfo mInfo) {

	}

	public void filterMessagesAndDisplay(MessageInfo messageInfo) {
		
	}
	
	public int getFilter() {
		return (Integer) null;
	}

}
