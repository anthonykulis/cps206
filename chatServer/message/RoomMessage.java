package chatServer.message;

import chatServer.room.Room;
import chatServer.user.User;

public class RoomMessage extends Message {

	private final Room room;
	private final User user;

	private RoomMessage(){
		this.room = null;
		this.user = null;
	}

	public RoomMessage(Room room, User user, String message){
		super(message);
		this.room = room;
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public User getUser() {
		return user;
	}

	/* tests */
	public static void main(String... args){
		User user = new User("user");
		Room room = new Room("room");
		String message = "message";

		RoomMessage roomMessage = new RoomMessage(room, user, message);

		assert roomMessage.getRoom() == room : "rooms are not the same";
		assert roomMessage.getUser() == user : "users are not the same";

	}
}
