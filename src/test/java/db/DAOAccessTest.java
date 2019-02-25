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

import db.DAOAccess;

public class DAOAccessTest {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Test
	public void testGetAllMessagesWorking() throws Exception {
		try {
			DAOAccess db = new DAOAccess();
			connect = db.getAllMessages();	
			//check if connect is filled
			assertTrue(connect!=null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Rule
	public ExpectedException thrown= ExpectedException.none();

	// check if no exception is thrown
	@Test
	public void throwsNothing() throws Exception {
		DAOAccess db = new DAOAccess();
		connect = db.getAllMessages();
	}

}
