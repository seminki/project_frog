package com.toyspace.chat.controller;

import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.toyspace.chat.model.vo.Message;

public class MessageEncoder implements Text<Message>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}
//java 객체를 javascript로 변환해주는 메소드
	@Override
	public String encode(Message object) throws EncodeException {
		// TODO Auto-generated method stub
		return new Gson().toJson(object);
	}
	
}
