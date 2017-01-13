package chatServer.direct;

import chatServer.user.User;

import java.util.Date;

public class Direct {

	private final User from;
	private final User to;
	private final Date timeStamp;
	private final String message;
	private boolean pending;
	private boolean messageTruncated;

	private Direct(){
		this.from = null;
		this.to = null;
		this.timeStamp = null;
		this.message = null;
		this.pending = false;
		this.messageTruncated = false;

	}

	public Direct(User from, User to, String message){
		this.from = from;
		this.to = to;
		this.timeStamp = new Date();
		this.pending = true;
		this.messageTruncated = message.length() > 2048;
		this.message = messageTruncated ? (message.substring(0, 2048) + "...") : message;
	}

	public User getFrom(){ return from; }

	public User getTo(){ return to; }

	public String getMessage(){ return message; }

	public boolean isPending(){ return pending; }

	public boolean isMessageTruncated(){ return messageTruncated; }

	public Date getTimeStamp(){ return timeStamp; }

	public String toString(){
		return from.toString() + " >> " + to.toString() + "\n" + timeStamp.toString() + ": " + message;
	}
}
