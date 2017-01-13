package chatServer.message;

import chatServer.user.User;
import chatServer.user.Users;

public class MessageCreator {

	public void createDirectMessage(User from, User to, String message) throws Exception {
		Users users = new Users();
		if(!users.isLoggedIn(from)) throw new Exception("User sending message is not logged in");
		if(!users.isUser(to)) throw new Exception("Unknown recipient");

		DirectMessage directMessage = new DirectMessage(from, to, message);
		MessageHistory messageHistory = new MessageHistory();
		messageHistory.addMessage(directMessage);

	}

}
