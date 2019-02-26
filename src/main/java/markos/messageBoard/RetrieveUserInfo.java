package markos.messageBoard;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DAOAccess;
import services.UserInfo;

public class RetrieveUserInfo implements UserInfo{

	DAOAccess db = new DAOAccess();
	public List<User> listUsers() throws Exception {
		

		List<User> listAllUsers = new ArrayList<User>();

		// retrieve data from the database
		ResultSet allUsers = db.getListUsers();

		//User userReturn;
		while (allUsers.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);

			String username = allUsers.getString("username");
			String name = allUsers.getString("name");
			String email = allUsers.getString("email");
			int stars = allUsers.getInt("star");
			//userReturn = new User(username, name, email);
			listAllUsers.add(new User(username, name, stars));      	
		}

		return listAllUsers;
	}
}


