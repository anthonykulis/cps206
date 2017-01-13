package chatServer.message;

import chatServer.room.Room;
import chatServer.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageHistory {

	private final static ArrayList<Message> messages = new ArrayList<>();

	public void addMessage(Message message){
		messages.add(message);
	}

	public List<Message> getUnsentDirectMessages(User from, User to){

		// get direct messages
		List<Message> direct = messages.stream().filter(message -> message instanceof DirectMessage).collect(Collectors.toList());

		return direct.parallelStream().filter(message -> {
			DirectMessage directMessage = (DirectMessage)message;
			return !directMessage.isSent() && directMessage.getFrom() == from && directMessage.getTo() == to;
		}).collect(Collectors.toList());
	}

	public List<Message> getRoomMessages(Room room){

		// Get room messages
		List<Message> roomMessages = messages.stream().filter(message -> message instanceof RoomMessage).collect(Collectors
						.toList());

		return roomMessages.parallelStream().filter(message -> {
			RoomMessage roomMessage = (RoomMessage) message;
			return roomMessage.getRoom() == room;
		}).collect(Collectors.toList());
	}

	/* tests */

	public static void main(String... args){
		MessageHistory messageHistory = new MessageHistory();

		Room room = new Room("room");
		User from = new User("from");
		User to = new User("to");
		String message = "message";

		DirectMessage directMessage = new DirectMessage(from, to, message);
		RoomMessage roomMessage = new RoomMessage(room, from, message);

		messageHistory.addMessage(directMessage);
		messageHistory.addMessage(roomMessage);

		assert messageHistory.getRoomMessages(room).size() == 1 : "room messages returned improper message count";
		assert messageHistory.getUnsentDirectMessages(from, to).size() == 1 : "direct unsent messages improper count";
		directMessage.markAsSent();
		assert messageHistory.getUnsentDirectMessages(from, to).size() == 0 : "direct is returning sent messages";
	}
}
