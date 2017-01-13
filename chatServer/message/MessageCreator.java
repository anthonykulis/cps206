package chatServer.message;

import chatServer.room.Room;
import chatServer.room.Rooms;
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

	public void createRoomMessage(Room room, User user, String message) throws Exception {
		Users users = new Users();
		if(!users.isLoggedIn(user)) throw new Exception("User posting message is not logged in");

		Rooms rooms = new Rooms();
		if(!rooms.roomExists(room)) throw new Exception("Cannot post to a non-existent room");

		RoomMessage roomMessage = new RoomMessage(room, user, message);
		MessageHistory messageHistory = new MessageHistory();
		messageHistory.addMessage(roomMessage);

	}

	/* no tests - these are integration tests and require mocks outside simple pojos */
}
