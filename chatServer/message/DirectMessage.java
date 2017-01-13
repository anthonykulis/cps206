package chatServer.message;

import chatServer.user.User;

public class DirectMessage extends Message {

	private final User from;
	private final User to;
	private boolean sent;

	private DirectMessage(){
		this.from = null;
		this.to = null;
		this.sent = true;
	}

	public DirectMessage(User from, User to, String message){
		super(message);
		this.from = from;
		this.to = to;
	}

	public User getFrom() {
		return from;
	}

	public User getTo() {
		return to;
	}

	public boolean isSent() {
		return sent;
	}

	public void markAsSent(){ this.sent = true; }

	/* Tests */
	public static void main(String... args){

		User from = new User("anthony");
		User to = new User("tom");
		String message = "test message";

		DirectMessage directMessage = new DirectMessage(from, to, message);

		assert from == directMessage.getFrom() : "from is not who sent it";
		assert to == directMessage.getTo() : "to is not who should receive it";
		assert !directMessage.isSent() : "some how the message has been sent when there is no reason to send it";
		directMessage.markAsSent();
		assert directMessage.isSent() : "sent message is not marked as sent";
	}
}
