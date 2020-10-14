package com.toyspace.common.listener;

import java.util.TreeMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.toyspace.member.model.vo.Member;
import com.toyspace.order.cart.model.service.CartService;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent e)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent e)  { 
         HttpSession session = e.getSession();
         if(session.getAttribute("signedInMember")!=null&&session.getAttribute("cart")!=null) {
        	 @SuppressWarnings("unchecked")
        	 TreeMap<Integer, Integer> cartValues=(TreeMap<Integer, Integer>)session.getAttribute("cart");
        	 Member m = (Member)session.getAttribute("signedInMember");
        	 int memberKey = m.getMemberKey();
        	 boolean result = new CartService().updateMemberCartValues(memberKey, cartValues);
        	 
        	 if(result) System.out.println(memberKey+"님의 장바구니가 업데이트 되었습니다.");
        	 else System.out.println(memberKey+"님의 장바구니 업데이트에 실패했습니다.");
         }
    }
	
}
