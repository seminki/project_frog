package com.toyspace.chat.controller;

import javax.websocket.DecodeException;
import javax.websocket.Decoder.Text;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.toyspace.chat.model.vo.Message;

public class MessageDecoder implements Text<Message> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}
	//javascript형식의 문자열을 java객체에 대입해줌.
	@Override
	public Message decode(String s) throws DecodeException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(s, Message.class);
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
