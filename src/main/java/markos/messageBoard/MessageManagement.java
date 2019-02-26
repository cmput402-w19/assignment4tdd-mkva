package markos.messageBoard;

import java.util.List;
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

	public void filterMessagesAndDisplay(MessageInfo messageInfo) throws Exception {
		Scanner userOk = new Scanner(System.in);
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
