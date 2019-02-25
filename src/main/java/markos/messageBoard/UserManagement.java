package markos.messageBoard;

import java.util.List;
import java.util.Scanner;

import db.DAOAccess;
import services.UserInfo;

public class UserManagement {

	DAOAccess db = new DAOAccess();
	private int filter;

	public User userLogin() throws Exception {
		User user = new User("usernamefoo", "nameX", "usernamefoo@email.com");
		return user;

	}

	public User userRegister() throws Exception {
		Scanner userInfo = new Scanner(System.in);
    	String nameInput, emailInput, usernameInput, passwordInput;
    	
		System.out.println("\n Please provide your information below:\n");
		System.out.println("\nName: ");
		nameInput = userInfo.nextLine();
		System.out.println("\nEmail: ");
		emailInput = userInfo.nextLine();
		System.out.println("\nUsername: ");
		usernameInput = userInfo.nextLine();
		System.out.println("\nPassword: ");
		passwordInput = userInfo.nextLine();
		User user = new User(usernameInput, nameInput, emailInput);
		return db.registerUser(nameInput, emailInput, usernameInput,passwordInput);
	}

	public void filterUsersAndDisplay(UserInfo userInfo) throws Exception {

		Scanner userOk = new Scanner(System.in);
		List<User> allUsers = userInfo.listUsers();
		System.out.println("\nAll current users with more than one star.\n");
		System.out.println("\n--------------------------------------------------------------------");
		System.out.println("\n--------------------------------------------------------------------\n");
		boolean noUserWithStars = true;
		filter=0;

		if(allUsers.isEmpty()) {
			System.out.println("\nThere is no registered user.\n");
			Thread.sleep(3000);
		}

		for (User user:allUsers) {
			if(user.getStars() > 0 ) {
				filter++;
				noUserWithStars = false;
				System.out.println("Username: " + user.getUsername() + "\n");
				System.out.println("Name : " + user.getName() + "\n");
				System.out.println("Number of stars : " + user.getStars() + "\n");
				System.out.println("\n--------------------------------------------------------------------\n");
			}
		}

		if(noUserWithStars) {
			System.out.println("\nThere is no user with more than 1 star.\n");
			Thread.sleep(3000);
		}
	}

	public int getFilter() {
		return this.filter;
	}
}
