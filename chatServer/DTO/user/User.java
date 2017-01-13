package chatServer.DTO.user;

import java.io.Serializable;

public class User extends chatServer.user.User implements Serializable {

	private static final long serialVersionUID = 8722436355824920815L;

	private User(){}

	public User(String name){
		super(name);
	}

}
