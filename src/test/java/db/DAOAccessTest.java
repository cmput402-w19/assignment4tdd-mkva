package db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.xdevapi.Statement;

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

}
