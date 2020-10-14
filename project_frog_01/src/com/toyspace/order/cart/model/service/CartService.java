package com.toyspace.order.cart.model.service;

import static com.toyspace.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.TreeMap;

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
	
}
