package db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mysql.cj.xdevapi.Statement;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import db.DAOAccess;
import markos.messageBoard.User;

public class DAOAccessTest {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Test
	public void testAllMessages() throws Exception {
		DAOAccess db = new DAOAccess();
		db.getAllMessages();
	}
	
	@Test
	public void testNewMessage() throws Exception {
		DAOAccess db = new DAOAccess();
		User u1 = new User("markosva", "markos", "markos@email.com");
		db.registerNewMessage(u1, "this is a content");
	}
	
	
}
