package com.toyspace.product.model.dao;

import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import com.toyspace.product.model.vo.Product;

public class ProductDao {

	private Properties prop=new Properties();
	
	public ProductDao() {
		// TODO Auto-generated constructor stub
		try {
			String path=ProductDao.class.getResource("/sql/product/product_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public int nextSeq(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int productId = -1;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("nextSeq"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				productId=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
			productId=-1;
		} finally {
			close(rs);
			close(pstmt);
		}
		return productId;
	}
	public boolean insertProduct(Connection conn, int productId, Product insertion) {
		
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertProduct"));
			pstmt.setInt(1, productId);
			pstmt.setInt(2, insertion.getCategoryNo());
			pstmt.setNString(3, insertion.getProductName());
			pstmt.setDouble(4, insertion.getProductPrice());
			pstmt.setInt(5, insertion.getProductStock());
			pstmt.setNString(6, insertion.getProductDescription());
			pstmt.setNString(7, insertion.getManufacturer());
			pstmt.setNString(8, insertion.getManufacturedCountry());
			pstmt.setInt(9, insertion.getRecommendedAge());
			pstmt.setNString(10, insertion.getCaution());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			result=-1;
		} finally {
			close(pstmt);
		}
		
		return result==1;
	}
	public boolean insertFilePathsIntoProduct(Connection conn, int productId, List<String> filePaths) {
		PreparedStatement pstmt = null;
		int[] result = {};
		
		try{
			pstmt = conn.prepareStatement(prop.getProperty("insertFilePathsIntoProduct"));
			
			for(int i =0; i<filePaths.size(); i++) {
				pstmt.setInt(1, productId);
				pstmt.setInt(2, i+1);
				pstmt.setNString(3, filePaths.get(i));
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			result = pstmt.executeBatch();
			
		} catch (Exception e) {
			// TODO: handle exception
			result = new int[]{};
		} finally {
			close(pstmt);
		}
		
		return result.length==filePaths.size();
	}
	
	public boolean insertTagsIntoProduct(Connection conn, int productId, List<Integer> tagList) {
		PreparedStatement pstmt = null;
		int[] result = {};
		
		try{
			pstmt = conn.prepareStatement(prop.getProperty("insertTagsIntoProduct"));
			
			for(int v : tagList) {
				pstmt.setInt(1, productId);
				pstmt.setInt(2, v);
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			result = pstmt.executeBatch();
			
		} catch (Exception e) {
			// TODO: handle exception
			result = new int[]{};
		} finally {
			close(pstmt);
		}
		
		return result.length==tagList.size();
	}
}
