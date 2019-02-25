package markos.messageBoard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

	private String username;
	private String name;
	private String email;
	private int stars;

	public User(String username, String name, String email) throws Exception {
		try {
			if(validUsername(username))
				this.username = username;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	// Alternative constructor to instantiate User with information retrieved from db
	public User(String username, String name, int stars) {

	}

	public boolean validUsername(String username) throws Exception {
		Exception emptyUsername = new Exception("\nInvalid username! Usernames cannot be empty.");
		Exception specialCharactersyUsername = new Exception("Invalid username! Usernames cannot"
				+ " have special characters.");
		// check if username is empty
		if(username.isEmpty())
			throw emptyUsername;

		// check if username contains special characters
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(username);
		boolean containSpecialCharacter = m.find();
		if(containSpecialCharacter)
			throw specialCharactersyUsername;

		return true;
	}

	public String getUsername() {
		return null;
	}

	public String getName() {
		return null;
	}

	public String getEmail() {
		return null;
	}

	public int getStars() {
		return (Integer) null;
	}
}
