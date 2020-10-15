package com.toyspace.chat.model.vo;

public class Message {
	
	private String sender;
	private String msg;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String sender, String msg) {
		super();
		this.sender = sender;
		this.msg = msg;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", msg=" + msg + "]";
	}	
	
	
}
