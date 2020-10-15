package com.toyspace.order.history.model.service;

import static com.toyspace.common.JDBCTemplate.close;
import static com.toyspace.common.JDBCTemplate.commit;
import static com.toyspace.common.JDBCTemplate.getConnection;
import static com.toyspace.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.TreeMap;

import com.toyspace.order.history.model.dao.OrderHistoryDao;
import com.toyspace.order.history.model.vo.OrderHistory;

public class OrderHistoryService {

	private OrderHistoryDao dao = new OrderHistoryDao();
	
	public OrderHistoryService() {
		// TODO Auto-generated constructor stub
	}
	
	public String createPaymentLog(int memberKey, TreeMap<Integer, Integer> cartValues, int totalAmount) {
		Connection conn = getConnection();
		int orderNo = dao.nextSeq(conn);
		String merchantUid = memberKey+"_"+System.currentTimeMillis();
		
		boolean result = dao.createPaymentLog(conn, orderNo, memberKey, merchantUid, totalAmount);
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
	
	public boolean cancelOrder(String merchant_uid) {
		Connection conn = getConnection();
		boolean result = dao.cancelOrder(conn, merchant_uid);
		if(result) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	
	public int loadTotalAmount(int memberKey, String merchantUid) {
		Connection conn =getConnection();
		int amount = dao.loadTotalAmount(conn, memberKey, merchantUid);
		close(conn);
		return amount;
	}
	
	public void updateSuccessStatus(String merchant_uid, OrderHistory oh) {
		Connection conn =getConnection();
		boolean result = dao.updateSuccessStatus(conn, merchant_uid, oh);
		if(!result) rollback(conn);
		else commit(conn);
		close(conn);
	}
	
	public ArrayList<OrderHistory> loadMemberOrderHistory(int memberKey){
		Connection conn =getConnection();
		ArrayList<OrderHistory> orderHistories = dao.loadMemberOrderHistory(conn,memberKey);
		close(conn);
		return orderHistories;
	}
}
