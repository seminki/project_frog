package com.toyspace.order.cart.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.TreeMap;

import static com.toyspace.common.JDBCTemplate.*;

public class CartDao {

	private Properties prop = new Properties();
	
	public CartDao() {

		try {
			String path = CartDao.class.getResource("/sql/cart/cart_sql.properties").getPath();
			prop.load(new FileReader(path));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////////////////////////////
////////////////////////////공용부///////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	
	
//////////////////////////////////////////////////////////////////////////
	public boolean removeAllCartValuesFromMember(Connection conn, int memberKey) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("removeAllCartValuesFromMember"));
			pstmt.setInt(1, memberKey);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result>=0;
	}
	
	public boolean insertMemberCartValues(Connection conn,int memberKey, TreeMap<Integer, Integer> cartValues) {
		int[] result= {};
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertMemberCartValues"));
			for(int productKey : cartValues.keySet()) {
				pstmt.setInt(1, memberKey);
				pstmt.setInt(2, productKey);
				pstmt.setInt(3, cartValues.get(productKey));
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			result=pstmt.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result.length==cartValues.size();
	}
}
	
