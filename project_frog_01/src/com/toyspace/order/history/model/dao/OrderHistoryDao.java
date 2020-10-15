package com.toyspace.order.history.model.dao;

import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

import com.toyspace.order.history.model.vo.OrderHistory;



public class OrderHistoryDao {

	private Properties prop = new Properties();
	
	public OrderHistoryDao() {
		// TODO Auto-generated constructor stub
		try {
			String path = OrderHistoryDao.class.getResource("/sql/order/order_sql.properties").getPath();
			prop.load(new FileReader(path));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
///////////////////////////////////////////////////////////////
	////////////////////공용//////////////////////////
	public int nextSeq(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int orderNo = -1;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("nextSeq"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				orderNo=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
			orderNo=-1;
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderNo;
	}
	
	public OrderHistory orderHistoryConvention(ResultSet rs) throws Exception {
		return new OrderHistory(rs.getInt("order_no"), 0, rs.getInt("member_key"), 
				rs.getDate("ordered_date"), rs.getNString("payment_method"), rs.getInt("order_status_no"), 
				rs.getString("apply_num"), rs.getNString("merchant_uid"), rs.getNString("buyer_tel"), 
				rs.getNString("receiver_name"), rs.getNString("receiver_tel"), rs.getNString("RECEIVER_POSTCODE"), 
				rs.getNString("RECEIVER_ADDR"),rs.getString("RECEIVER_COMMENT"), null, rs.getInt("TOTAL_AMOUNT"));
	}
	
	/////////////////////////////////////////
	
	public boolean createPaymentLog(Connection conn, int orderNo, int memberKey, String merchantUid, int totalAmount) {
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("createPaymentLog"));
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, memberKey);
			pstmt.setString(3, merchantUid);
			pstmt.setInt(4, totalAmount);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("다오레벨에서 결제정보 생성에 실패!");
		} finally {
			close(pstmt);
		}
		
		return result==1;
	}
	
	public boolean insertCartValuesToOrder(Connection conn, int orderNo, TreeMap<Integer, Integer> cartValues) {
		PreparedStatement pstmt = null;
		int[] result = {};
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertCartValuesToOrder"));
			for(int productId : cartValues.keySet()) {
				pstmt.setInt(1, orderNo);
				pstmt.setInt(2, productId);
				pstmt.setInt(3, cartValues.get(productId));
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			
			result = pstmt.executeBatch();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("다오 레벨에서 카트 밸류 db저장 실패");
		} finally {
			close(pstmt);
			
		}
		
		return result.length==cartValues.size();
	}
	
	public boolean cancelOrder(Connection conn, String merchant_uid) {
		PreparedStatement pstmt = null;
		int result =-1;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("cancelOrder"));
			pstmt.setString(1, merchant_uid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result == 1;
	}
	
	public int loadTotalAmount(Connection conn, int memberKey, String merchantUid) {
		int amount = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadTotalAmount"));
			pstmt.setInt(1, memberKey);
			pstmt.setString(2, merchantUid);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				amount = rs.getInt("TOTAL_AMOUNT");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return amount;
	}
	
	public boolean updateSuccessStatus(Connection conn, String merchant_uid, OrderHistory oh) {
		int result =-1;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateSuccessStatus"));
			pstmt.setNString(1, oh.getPaymentMethod());
			pstmt.setNString(2, oh.getApplyNum());
			pstmt.setString(3, oh.getBuyerTel());
			pstmt.setString(4, oh.getReceiverName());
			pstmt.setString(5, oh.getBuyerTel());
			pstmt.setString(6, ""+oh.getReceiverPostcode());
			pstmt.setNString(7, oh.getReceiverAddr());
			pstmt.setNString(8, merchant_uid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result == 1;
	}
	
	public ArrayList<OrderHistory> loadMemberOrderHistory(Connection conn, int memberKey){
		ArrayList<OrderHistory> orderHistories = new ArrayList<OrderHistory>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadMemberOrderHistory"));
			pstmt.setInt(1, memberKey);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				OrderHistory oh = orderHistoryConvention(rs);
				orderHistories.add(oh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderHistories;
	}
	
	public ArrayList<OrderHistory> loadAllOrderHistories(Connection conn){
		ArrayList<OrderHistory> orderHistories = new ArrayList<OrderHistory>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadAllOrderHistories"));
			
			rs= pstmt.executeQuery();
			while(rs.next()) {
				OrderHistory oh = orderHistoryConvention(rs);
				orderHistories.add(oh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderHistories;
	}
}
