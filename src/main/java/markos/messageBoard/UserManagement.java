package markos.messageBoard;

import java.util.List;
import java.util.Scanner;

import services.UserInfo;

public class UserManagement {

	private int filter;

	public User userLogin() throws Exception {
		User user = new User("usernamefoo", "nameX", "usernamefoo@email.com");
		return user;

	}

	public User userRegister() {
		return null;

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
