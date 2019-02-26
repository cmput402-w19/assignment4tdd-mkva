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
		//Message messageReturn;
		
        while (allMessages.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
        	       	
        	int id = allMessages.getInt("id");
        	int type = allMessages.getInt("type");
        	int parent = allMessages.getInt("parent");
        	String content = allMessages.getString("content");
        	String author = allMessages.getString("author");
        	String date = allMessages.getString("date");
        	
        	//messageReturn = new Message(type, id, parent, content, author, date);
        	listAllMessages.add(new Message(type, id, parent, content, author, date));      	
        }
        
		return listAllMessages;
	}

}
