package markos.messageBoard;

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
	
	public boolean validUsername(String username) {
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
