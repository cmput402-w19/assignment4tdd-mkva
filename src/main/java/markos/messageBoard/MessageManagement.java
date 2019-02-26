package markos.messageBoard;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import db.DAOAccess;
import services.MessageInfo;

public class MessageManagement {

	DAOAccess db = new DAOAccess();
	Scanner option = new Scanner(System.in);
	private int filter;

	public void viewMessages(User currentUser)  {

		// View all messages
		RetrieveMessageInfo mInfo = new RetrieveMessageInfo();

		while(true) {
			displayAllMessages(mInfo);

			// Give user options to post message or answer message
			System.out.println("\n\nPlease enter 'new' if you want to post a new message, "
					+ "'ans' followed by id (like [ans 2], if you want to answer any message, "
					+ "or 'ret' to return to the main screen.\n");

			String userOption = option.nextLine();
			if(userOption.equals("ret"))
				return;
			if(userOption.equals("new")) {
	    		postNewMessage(currentUser);
	    	}
			else if(userOption.split(" ")[0].equals("ans") && StringUtils.isNumeric(userOption.split(" ")[1])) {
				int parent = Integer.parseInt(userOption.split(" ")[1]);
				postNewMessageAnswer(currentUser, parent);
			}
			else
				System.out.println("\nPlease enter a valid option.\n");
		}	
	}

	private void postNewMessageAnswer(User currentUser, int parent)  {

	}

	public void postNewMessage(User currentUser) {

		
	}

	public void displayAllMessages(RetrieveMessageInfo mInfo) {

	}

	public void filterMessagesAndDisplay(MessageInfo messageInfo) throws Exception {
		List<Message> allMessages = messageInfo.listAllMessages();

		System.out.println("\nAll current messages that are answers to other messages.\n");
		System.out.println("\n--------------------------------------------------------------------");
		System.out.println("\n--------------------------------------------------------------------\n");
		boolean noMessagesAnswers = true;

		filter=0;
		if(allMessages.isEmpty())
			System.out.println("\nThere is no message.\n");
		for (Message mess:allMessages) {
			if(mess.getType() == 2) {
				filter++;
				noMessagesAnswers = false;
				System.out.println("ID : " + mess.getId() + " (Answer to message " + mess.getParent() +  ")\n");
				System.out.println("Message: " + mess.getContent() + "\n");
				System.out.println("Author : " + mess.getAuthor() + "\n");
				System.out.println("Date : " + mess.getDate() + "\n");
				System.out.println("\n--------------------------------------------------------------------\n");
			}
		}

		if(noMessagesAnswers) {
			System.out.println("\nThere is no message which is answer.\n");
			Thread.sleep(3000);
		}
	}

	public int getFilter() {
		return this.filter;
	}

}
