package markos.messageBoard;

public class User {

	private String username;
	private String name;
	private String email;
	private int stars;
	
	public User(String username, String name, String email) throws Exception {

	}
	
	// Alternative constructor to instantiate User with information retrieved from db
	public User(String username, String name, int stars) {

	}
	
	public boolean validUsername(String username) {
		return (Boolean) null;
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
