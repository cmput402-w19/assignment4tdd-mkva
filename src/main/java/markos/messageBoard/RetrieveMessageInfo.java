package markos.messageBoard;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DAOAccess;
import services.MessageInfo;

public class RetrieveMessageInfo implements MessageInfo{

	DAOAccess db = new DAOAccess();
public List<Message> listAllMessages() throws Exception {
		
		List<Message> listAllMessages = new ArrayList<Message>();
		
		// retrieve data from the database
		ResultSet allMessages = db.getListMessages();
		
        while (allMessages.next()) {
        	       	
        	int id = allMessages.getInt("id");
        	int type = allMessages.getInt("type");
        	int parent = allMessages.getInt("parent");
        	String content = allMessages.getString("content");
        	String author = allMessages.getString("author");
        	String date = allMessages.getString("date");
        	
        	listAllMessages.add(new Message(type, id, parent, content, author, date));      	
        }
        
		return listAllMessages;
	}

}
