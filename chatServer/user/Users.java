package chatServer.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

	private static ArrayList<User> users = new ArrayList<>();
	private static HashSet<User> loggedInUsers = new HashSet<>();

	public boolean isNewUser(User test){
		return getUserByName(test.getName()) == null;
	}

	public User getUserByName(String name){
		List list =  users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
		if(list.size() > 0) return (User) list.get(0);
		return null;
	}

	public void addUser(User user) throws Exception {
		if(!isUser(user)) throw new Exception("User already exists");
		users.add(user);
	}

	public boolean logInUser(User test){
		List list = findByUUID(test);
		if(list.size() > 0){
			loggedInUsers.add(test);
			return true;
		}
		return false;
	}

	public boolean logOutUser(User test){
		List list = findByUUID(test);
		if(list.size() > 0){
			loggedInUsers.remove(test);
			return true;
		}
		return false;
	}

	public boolean isLoggedIn(User user){
		return loggedInUsers.parallelStream().filter(loggedIn -> loggedIn.getUUID().equals(user.getUUID())).findFirst() !=
						null;
	}

	public boolean isUser(User user){
		return users.parallelStream().filter(test -> test.getUUID().equals(user.getUUID())).findFirst() != null;
	}

	private List findByUUID(User test){
		return users.stream().filter(user -> user.UUID.equals(test.UUID)).collect(Collectors.toList());
	}

	/* Tests */
	public static void main(String... args){
		Users users = new Users();

		User anthony = new User("anthony");
		User tom = new User("tom");

		assert users.isNewUser(anthony) : "test user should be new user";
		try {
			users.addUser(anthony);
		} catch (Exception e){
			assert false : "adding user failed when no user was present";
		}

		assert !users.isNewUser(anthony) : "test user should not be new user";

		assert users.getUserByName("anthony") == anthony : "getting by name returned wrong test user";
		assert users.getUserByName("tom") == null : "trying to find unknown user returns something besides null";

		assert users.logInUser(anthony) : "logging in test user failed";
		assert users.logInUser(anthony) : "trying to log in test user again failed to allow it";

		assert !users.logInUser(tom) : "logging in unknown user allowed it";

		assert users.logOutUser(anthony) : "logging out test user who is logged in failed";
		assert !users.logOutUser(tom) : "logging out unknown user allowed it";

		try {
			users.addUser(tom);
		} catch (Exception e){}

		assert !users.isNewUser(tom) : "checkign to see if new user when not and there is more than one failed";
		assert users.getUserByName("tom") == tom : "getting user by name with multiple users doesn't return correct user";
		assert users.logInUser(tom) : "logging in user with multiple users failed";
		assert users.logOutUser(tom) : "loggin out user with multiple users faied";

	}
}
