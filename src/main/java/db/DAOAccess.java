package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import markos.messageBoard.User;

public class DAOAccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void initialize() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mysql://localhost/messageBoard", "root", "markosalberta");
	}

	public Connection getAllMessages() throws Exception {
		try {
			initialize();
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement
					.executeQuery("select * from messageBoard.post");
			writeMessages(resultSet);

		} catch (Exception e) {
			throw e;
		} 
		return connect;
	}

	private void writeMessages(ResultSet resultSet) {

	}

	public User getUserLogin(String usernameInput, String passwordInput)  {
		return null;

	}


	public User registerUser(String nameInput, String emailInput, String usernameInput, String passwordInput)  {
		return null;

	}

	public void registerNewMessage(User currentUser, String content)  {


	}

	public void registerNewMessageAnswer(User currentUser, String content, int parent) {

	}

	public ResultSet getListUsers() {
		return resultSet;


	}

	public ResultSet getListMessages() {
		return resultSet;

	}
}
