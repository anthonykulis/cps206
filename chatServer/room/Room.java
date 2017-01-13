package chatServer.room;

import chatServer.user.User;

import java.util.HashSet;

public class Room {

	private final String UUID;
	private final String name;
	private final HashSet<User> visitors;

	private Room(){
		this.UUID = null;
		this.name = null;
		this.visitors = null;
	}

	public Room(String name){
		this.UUID = java.util.UUID.randomUUID().toString();
		this.name = name;
		this.visitors = new HashSet<>();
	}

	public String getUUID() {
		return UUID;
	}

	public String getName() {
		return name;
	}

	public HashSet<User> getVisitors() {
		return new HashSet<User>(visitors);
	}

	public void addVisitor(User user){
		this.visitors.add(user);
	}


	/* Tests */
	public static void main(String... args){
		String roomName = "room";
		Room room = new Room(roomName);
		User anthony = new User("anthony");

		assert room.getName().equals(roomName) : "room names do not match";
		assert room.getUUID() != null : "room UUID never set";

		assert room.getVisitors().size() == 0 : "room has vistors with no vistors";
		room.addVisitor(anthony);

		assert room.getVisitors().size() == 1 : "room doesn't have only one visitor when only one vistor was added";
	}
}
