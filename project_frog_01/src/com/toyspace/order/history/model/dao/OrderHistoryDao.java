package com.toyspace.order.history.model.dao;

import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.TreeMap;



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
	
	/////////////////////////////////////////
	
	public boolean createPaymentLog(Connection conn, int orderNo, int memberKey, String merchantUid) {
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("createPaymentLog"));
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, memberKey);
			pstmt.setString(3, merchantUid);
			
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
}
