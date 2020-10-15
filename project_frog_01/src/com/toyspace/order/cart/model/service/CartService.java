package com.toyspace.order.cart.model.service;

import static com.toyspace.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import com.toyspace.order.cart.model.dao.CartDao;

public class CartService {

	private CartDao dao = new CartDao();
	
	public CartService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean updateMemberCartValues(int memberKey, TreeMap<Integer, Integer> cartValues) {
		Connection conn = getConnection();
		boolean result=dao.removeAllCartValuesFromMember(conn,memberKey);
		if(!result) {
			rollback(conn);
			close(conn);
			return result;
		}
		result=dao.insertMemberCartValues(conn,memberKey,cartValues);
		if(!result) rollback(conn);
		else commit(conn);
		close(conn);
		
		return result;
	}
	
	public TreeMap<Integer, Integer> loadSavedCart(int memberKey){
		Connection conn =getConnection();
		
		TreeMap<Integer, Integer> savedCart = dao.loadSavedCart(conn, memberKey);
		
		close(conn);
		return savedCart;
	}
	
	public void loadSavedCart(HttpSession session, int memberKey) {
		
		////////////////////////////////////////////////////////////////////////////////
		//////////장바구니 로직/////////////////////////////
//		멤버의 저장된 장바구니 불러오기
		TreeMap<Integer, Integer> savedCart = loadSavedCart(memberKey);
//		지금 세션의 장바구니 불러오기
		TreeMap<Integer, Integer> currentCart =(TreeMap<Integer, Integer>)session.getAttribute("cart");
//		지금 장바구니가 있으면 지금 장바구니에 저장된 장바구니를 합쳐주고,
//		아니라면 저장된 장바구니를 바로 지금 세션의 장바구니로 등록
		if(currentCart==null) {
			session.setAttribute("cart", savedCart);
			
		} else {
			if(savedCart!=null) {
				for(int productId : savedCart.keySet()) {
					if(!currentCart.containsKey(productId)) {
						currentCart.put(productId, savedCart.get(productId));
					} else {
						currentCart.replace(productId, currentCart.get(productId)+savedCart.get(productId));
					}
				}
			}
			session.setAttribute("cart", currentCart);
		}
		/////////////////////////////////////////
	}
	
}
