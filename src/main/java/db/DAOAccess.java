package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

import markos.messageBoard.User;

public class DAOAccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void initialize() {

	}

	public void getAllMessages() {

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
