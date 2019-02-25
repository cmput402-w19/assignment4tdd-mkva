package services;

import java.util.List;

import markos.messageBoard.Message;

public interface MessageInfo {

	public List<Message> listAllMessages() throws Exception;
}
