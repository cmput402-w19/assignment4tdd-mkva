package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public void getAllMessages() throws Exception {
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
	}

	private void writeMessages(ResultSet resultSet) throws SQLException {

		boolean noMessage = true;
    	System.out.println("\nAll current messages are displayed below.\n");
    	System.out.println("\n--------------------------------------------------------------------");
    	System.out.println("\n--------------------------------------------------------------------\n");
    	
        while (resultSet.next()) {
        	noMessage = false;
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
        	
        	int id = resultSet.getInt("ID");
        	int type = resultSet.getInt("type");
        	int parent = resultSet.getInt("parent");
        	String content = resultSet.getString("content");
        	String author = resultSet.getString("author");
        	String date = resultSet.getString("date");
        	
        	
        	if(parent == 0) { //this is not an answer
        		System.out.println("ID : " + id + "\n");
        		System.out.println("Message : " + content + "\n");
	        	System.out.println("Author : " + author + " -- " + date);
	        	System.out.println("\n--------------------------------------------------------------------\n");
        	}
        	else { //this is an answer
        		System.out.println("ID : " + id + "(answer to message " + parent + ")" + "\n");
	        	System.out.println("Message : " + content + "\n");
	        	System.out.println("Author : " + author + " -- " + date);
	        	System.out.println("\n--------------------------------------------------------------------\n");
	        	}
        }
        System.out.println("--------------------------------------------------------------------\n");
        
        if(noMessage)
        	System.out.println("\nThere is no message to be displayed!\n");
	}

	public User getUserLogin(String usernameInput, String passwordInput) throws Exception  {
		try {
			initialize();
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/messageBoard", "root", "markosalberta");

            preparedStatement = connect
                    .prepareStatement("select * from user where username=? and password=?");
                    preparedStatement.setString(1,usernameInput);
                    preparedStatement.setString(2,passwordInput);
            resultSet = preparedStatement.executeQuery();
            
            if(!resultSet.next()) //check if is empty
            	return null;
            User userCurrentlyLogged = new User(resultSet.getString("username"), resultSet.getString("name"),
            		resultSet.getString("email"));
            return userCurrentlyLogged;

        } catch (Exception e) {
            throw e;
        }

	}


	public User registerUser(String nameInput, String emailInput, String usernameInput, String passwordInput) throws Exception  {
		initialize();
		preparedStatement = connect
                .prepareStatement("insert into user values (?,?,?,?,0)");
		preparedStatement.setString(1, usernameInput);
        preparedStatement.setString(2, passwordInput);
        preparedStatement.setString(3, nameInput);
        preparedStatement.setString(4, emailInput);
		preparedStatement.executeUpdate();
		
		//return getUserLogin(usernameInput, passwordInput);
		return new User(usernameInput, nameInput, emailInput);

	}

	public void registerNewMessage(User currentUser, String content) throws ClassNotFoundException, SQLException  {

		initialize();
		preparedStatement = connect
                .prepareStatement("insert into messageBoard.post values (null, 1, null, ?,?,?, 0)");
		preparedStatement.setString(1, content);
		preparedStatement.setString(2, currentUser.getUsername());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
		preparedStatement.setString(3, formatter.format(date).toString());
		preparedStatement.executeUpdate();
		
		// update number of stars for current user
		preparedStatement = connect
                .prepareStatement("select star from user where username=?");
                preparedStatement.setString(1,currentUser.getUsername());
        resultSet = preparedStatement.executeQuery();
        int stars=0, newStars=0;
        while(resultSet.next()) {
        	stars = resultSet.getInt("star");
        	newStars = stars + 1;
        }    
        
        preparedStatement = connect
                .prepareStatement("UPDATE user SET star=? WHERE username=?");
        preparedStatement.setInt(1,newStars);
        preparedStatement.setString(2,currentUser.getUsername());
        preparedStatement.executeUpdate();		

	}

	public void registerNewMessageAnswer(User currentUser, String content, int parent) throws ClassNotFoundException, SQLException {

		initialize();
		preparedStatement = connect
                .prepareStatement("insert into messageBoard.post values (null, 2, ?,?,?,?, 0)");
		preparedStatement.setInt(1, parent);
		preparedStatement.setString(2, content);
		preparedStatement.setString(3, currentUser.getUsername());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
		preparedStatement.setString(4, formatter.format(date).toString());
		preparedStatement.executeUpdate();
		
		// update number of stars for current user
		preparedStatement = connect
				.prepareStatement("select star from user where username=?");
		        preparedStatement.setString(1,currentUser.getUsername());
		resultSet = preparedStatement.executeQuery();
		int stars=0, newStars=0;
        while(resultSet.next()) {
        	stars = resultSet.getInt("star");
        	newStars = stars + 1;
        } 
		       
		preparedStatement = connect
		        .prepareStatement("UPDATE user SET star=? WHERE username=?");
		preparedStatement.setInt(1,newStars);
		preparedStatement.setString(2,currentUser.getUsername());
		preparedStatement.executeUpdate();
	}

	public ResultSet getListUsers() throws Exception {
		try {
    		initialize();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from messageBoard.user");

        } catch (Exception e) {
            throw e;
        }
		return resultSet; 

	}

	public ResultSet getListMessages() throws Exception {
		try {
    		initialize();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from messageBoard.post");

        } catch (Exception e) {
            throw e;
        }
		return resultSet;  

	}
}
