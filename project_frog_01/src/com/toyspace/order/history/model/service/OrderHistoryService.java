package com.toyspace.order.history.model.service;

import static com.toyspace.common.JDBCTemplate.close;
import static com.toyspace.common.JDBCTemplate.getConnection;
import static com.toyspace.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.TreeMap;

import com.toyspace.order.history.model.dao.OrderHistoryDao;

public class OrderHistoryService {

	private OrderHistoryDao dao = new OrderHistoryDao();
	
	public OrderHistoryService() {
		// TODO Auto-generated constructor stub
	}
	
	public String createPaymentLog(int memberKey, TreeMap<Integer, Integer> cartValues) {
		Connection conn = getConnection();
		int orderNo = dao.nextSeq(conn);
		String merchantUid = memberKey+"_"+System.currentTimeMillis();
		
		boolean result = dao.createPaymentLog(conn, orderNo, memberKey, merchantUid);
		if(!result) {
			rollback(conn);
			close(conn);
			return null;
		}
		result = dao.insertCartValuesToOrder(conn, orderNo, cartValues);
		if(!result) {
			rollback(conn);
			close(conn);
			return null;
		}
		close(conn);
		return merchantUid;
	}
	
}
