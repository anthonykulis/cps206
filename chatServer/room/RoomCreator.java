package chatServer.room;

public class RoomCreator {

	public void create(String name) throws Exception {
		Rooms rooms = new Rooms();
		if(rooms.getRoomByName(name) != null) throw new Exception("Room already exists");
		Room room = new Room(name);
		rooms.addRoom(room);
	}

	/* Tests */
	public static void main(String... args){
		RoomCreator roomCreator = new RoomCreator();
		String roomName = "room";

		try {
			roomCreator.create(roomName);
		} catch (Exception e){
			assert false : "an exception occurred when making a legal room: " + e.getMessage();
		}

		boolean caught = false;
		try {
			roomCreator.create(roomName);
		} catch (Exception e){
			caught = true;
		}

		assert caught : "room was created when it already existed";

	}
}
