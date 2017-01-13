package chatServer.message;

import java.util.Date;

class Message {

	private String message;
	private Date timeStamp;
	private boolean messageTruncated;

	Message(){
		this.message = null;
		this.messageTruncated = false;
		this.timeStamp = new Date();
	}

	Message(String message){
		setMessage(message);
		this.timeStamp = new Date();
	}

	public String getMessage(){ return message; }
	public Date getTimeStamp(){ return timeStamp; }
	public boolean isMessageTruncated(){ return messageTruncated; }

	private void setMessage(String message){
		this.messageTruncated = message.length() > 2048;
		this.message = messageTruncated ? (message.substring(0, 2048) + "...") : message;
	}

	/* Tests */
	public static void main(String... args){
		String testMessage = "test message";
		String longMessage = "";
		for(int i = 0; i < 3000; i++) longMessage += "a long message ";

		Message message = new Message(testMessage);
		Message longMsg = new Message(longMessage);

		assert message.getMessage().equals(testMessage): "test message not equal to message sent";
		assert !message.isMessageTruncated() : "short test message has been truncated";
		assert message.getTimeStamp() != null : "test message has no time stamp";

		longMessage = longMsg.getMessage();
		assert longMessage.length() == 2051 : "long message not truncated properly";
		assert longMessage.substring(2048, 2051).equals("...") : "long message not tailed with ...";
		assert longMsg.isMessageTruncated() : "long message not marked as truncated";

	}
}
