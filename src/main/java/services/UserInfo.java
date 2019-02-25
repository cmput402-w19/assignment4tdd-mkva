package services;

import java.util.List;

import markos.messageBoard.User;

public interface UserInfo {
	
	List<User> listUsers() throws Exception;

}
