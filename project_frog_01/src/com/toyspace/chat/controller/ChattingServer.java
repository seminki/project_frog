package com.toyspace.chat.controller;

import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.toyspace.chat.model.vo.Message;

//websocket서버를 구성하는 방법

//websocket서버에서 javascript가 보낸 객체를 받고 javascript 객체 형식으로 보내려면
//encoder, decoder가 필요함
//서버에 encoder, decoder를 등록해주면 됨
//encoder와 decoder는 규약에 맞는 클래스로 작성을 해주면 됨.
//encoder : javascript 객체를 java객체로 변환해주는 역할을 하는 클래스
//decoder : java객체를 javascript 객체로 변환해주는 역할을 하는 클래스
//규약 : Encoder/Decoder.Text<vo 객체명>인터페이스를 구현한 클래스
@ServerEndpoint(value = "/chatting", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class})
public class ChattingServer {
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		//클라이언트 요청이 오면 실행되는 함수
		//클라이언트에서 new WebSocket()를 실행하면 실행되는 메소드
		
		
		//접속 성공했다는 메시지를 클라이언트에게 전송하기
		//전송방법
		//session.getBasicRemote() : 데이터를 전송할 클라이언트 스트림을 가져옴
		//session.getBasicRemote().sendText() : 문자열을 전송하는 메소드
		//예외처리를 해줘야 함
		Message m =new Message("admin","도움이 필요하신가요?");
		
		try {
			session.getBasicRemote().sendObject(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//클라이언트가 받은 메세지 받기
	@OnMessage
	public void message(Session session, Message msg) { //디코더 등록이 되어있을 때
		//session은 보낸 사람의 session객체임
		//msg는 클라이언트가 send한 매개변수가 msg 매개변수도 들어옴
		
		msg.setSender("["+msg.getSender()+"]");
		//받은 메세지 전송하기
		try {
			//본인한테만 보내지 말고, 모든 접속한 session에 데이터 보내기!
			//접속한 session 객체 가져오기
			//session.getOpenSession()메소드를 이용 -? 현재 서버에 접속되어 있는 session객체를 Set객체로 반환
			Set<Session> clients = session.getOpenSessions();
			for(Session s : clients) {
				s.getBasicRemote().sendObject(msg);
			}
					
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
