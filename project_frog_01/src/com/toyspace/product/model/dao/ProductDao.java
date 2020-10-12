package com.toyspace.product.model.dao;

import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	//상품리스트 (관리자:상품관리페이지)
	public ArrayList<Product> loadAllProducts(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Product> productsList=new ArrayList<Product>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loadAllProducts"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setProductId(rs.getInt("product_id"));
				p.setCategoryNo(rs.getInt("category_no"));
				p.setCategoryName(rs.getString("category_name"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getDouble("product_price"));
				p.setProductStock(rs.getInt("product_stock"));
				p.setProductDescription(rs.getString("product_description"));
				p.setManufacturer(rs.getString("manufacturer"));
				p.setManufacturedCountry(rs.getString("manufactured_country"));
				p.setRecommendedAge(rs.getInt("recommended_age"));
				p.setCaution(rs.getString("caution"));
				
				
				productsList.add(p);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productsList;
	}
////상품정보 불러오기(관리자:상품수정페이지용)
	public Product productInfo(Connection conn, String productId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("productInfo"));
			pstmt.setString(1, productId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=new Product();
				p.setProductId(rs.getInt("product_id"));
				p.setCategoryNo(rs.getInt("category_no"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getDouble("product_price"));
				p.setProductStock(rs.getInt("product_stock"));
				p.setProductDescription(rs.getString("product_description"));
				p.setManufacturer(rs.getString("manufacturer"));
				p.setManufacturedCountry(rs.getString("manufactured_country"));
				p.setRecommendedAge(rs.getInt("recommended_age"));
				p.setCaution(rs.getString("caution"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return p;
	}
//이미지 파일 불러오기
	public ArrayList<String> loadImageFilePaths(Connection conn, String productId){
		
		ArrayList<String> imageFilePaths = new ArrayList<String>(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loadImageFilePaths"));
			pstmt.setNString(1, productId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				imageFilePaths.add(rs.getString("IMAGE_ROUTE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return imageFilePaths;
	}
	public int updateProduct(Connection conn, Product p) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateProduct"));
			pstmt.setString(1, p.getProductName());
			pstmt.setDouble(2,p.getProductPrice());
			pstmt.setInt(3, p.getProductStock());
			pstmt.setString(4, p.getProductDescription());
			pstmt.setString(5, p.getManufacturer());
			pstmt.setString(6, p.getManufacturedCountry());
			pstmt.setInt(7, p.getRecommendedAge());
			pstmt.setString(8, p.getCaution());
			pstmt.setInt(9, p.getCategoryNo());
			pstmt.setInt(10, p.getProductId());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
