package markos.messageBoard;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Application 
{
	public static void main( String[] args ) throws Exception
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //clear the console
		System.out.println("\nHello! Press 's' to start the messaging application or 'c' to close the"
				+ " message application.\n\n");
		Scanner startApp = new Scanner(System.in);
		String userInput;

		while(true) {
			userInput = startApp.nextLine();
			if(userInput.equals("s")) {
				UserManagement userManag = new UserManagement();
				MessageManagement messageManag = new MessageManagement();
				initializeMessageApplication(userManag,messageManag);
				System.out.println("\nFinishing the messaging application. Bye!\n");
				break;
			}
			else if(userInput.equals("c")) {
				System.out.println("\nFinishing the messaging application. Bye!\n");
				return;
			}
			else {
				System.out.println("\nPlease enter a valid option.\n");
			}
		}
	}

	public static void initializeMessageApplication(UserManagement userManag, MessageManagement messageManag) throws Exception {
		while(true) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("\nPlease enter 'l' to log into the application, 'r' to register a new user,"
					+ " or 'c' to close the application.\n");
			Scanner loginRegister = new Scanner(System.in);
			String userOption = loginRegister.nextLine();


			if(userOption.equals("c"))
				return;
			if(userOption.equals("l")) {
				User currentLoggedUser = userManag.userLogin();
				if(currentLoggedUser == null) {
					System.out.println("\nUser does not exist, please register before.\n");
					continue;
				}
				else
					mainMessageApplication(currentLoggedUser, userManag, messageManag);
			}
			else if(userOption.equals("r")) {
				User currentLoggedUser=null;
				try {
					currentLoggedUser = userManag.userRegister();
					//User currentLoggedUser = new User("markosva", "Markos Viggiato", "markos@email.com");
				}
				catch(Exception e) {
					System.out.println("\nPlease do the operation again.\n");
					continue;
				}
				mainMessageApplication(currentLoggedUser, userManag, messageManag);

			}
			else {
				System.out.println("\nPlease enter a valid option.\n");
			}
		}

	}

	public static void mainMessageApplication(User currentUser, UserManagement userManag, MessageManagement messageManag) throws Exception {

		Scanner option = new Scanner(System.in);
		String userOption;

		while(true) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //clear the console
			System.out.println("\nPlease indicate what you would like to do: View Messages (v), "
					+ "View Information About the Application (i), or Log out (out)\n");

			userOption = option.nextLine();
			if(userOption.contentEquals("out"))
				return;

			if(userOption.contentEquals("v")) {
				messageManag.viewMessages(currentUser);
			}
			else if(userOption.contentEquals("i")) {
				//messageManag.viewMessageInfo(currentUser);
				while(true) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //clear the console
					System.out.println("\nPlease indicate the option below: \n");
					System.out.println("\n1: Get list of users with more than 1 star");
					System.out.println("\n2: Get number of messages that are answers to other messages");
					//System.out.println("\n3: Get number of messages that are not answers to other messages");
					System.out.println("\n3: Return");
					String userChoice = option.nextLine();

					if(userChoice.equals("1")) {
						RetrieveUserInfo retrieveUserInfo = new RetrieveUserInfo();
						userManag.filterUsersAndDisplay(retrieveUserInfo);
						break;
					}
					else if(userChoice.equals("2")) {
						RetrieveMessageInfo retrieveMessageInfo = new RetrieveMessageInfo();
						messageManag.filterMessagesAndDisplay(retrieveMessageInfo);
						break;
					}
					else if(userChoice.equals("3")) {
						break;
					}
					else {
						System.out.println("\nPlease enter a valid option.\n");
						Thread.sleep(3000);
						continue;
					}
				}


			}
			else {
				System.out.println("\nPlease enter a valid option.\n");
				Thread.sleep(3000);
				continue;
			}

		}
	}
}
