package chatServer.room;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Rooms {

	private static HashSet<Room> rooms = new HashSet<>();

	public boolean roomExists(Room room){
		return rooms.stream().filter(test -> test.getUUID().equals(room.getUUID())).collect(Collectors.toList()).size() > 0;
	}

	public void addRoom(Room room) throws Exception {
		if(roomExists(room)) throw new Exception("Room already exists");
		rooms.add(room);
	}

	public Room getRoomByName(String name){
		List<Room> hits = rooms.parallelStream().filter(test -> test.getName().equals(name)).collect(Collectors.toList());
		if(hits.size() == 0) return null;
		return hits.get(0);
	}

	public HashSet<Room> getRooms(){
		return new HashSet<Room>(rooms);
	}

	/* Tests */
	public static void main(String... args){
		Rooms rooms = new Rooms();
		Room room = new Room("room");

		assert !rooms.roomExists(room) : "room already exists before adding";

		try {
			rooms.addRoom(room);
		} catch (Exception e){
			assert false : "adding room through exception";
		}

		boolean caught = false;
		try {
			rooms.addRoom(room);
		} catch (Exception e){
			caught = true;
		}

		assert caught : "did not catch adding existing room";

		HashSet<Room> rooms1 = rooms.getRooms();
		HashSet<Room> rooms2 = rooms.getRooms();
		assert rooms2 != rooms1 : "rooms returned is not a new set";

		assert rooms1.size() == 1 : "only one room yet size differs";

		assert rooms.getRoomByName("room") == room : "did not find proper room by name";

	}
}
