package com.toyspace.product.model.dao;


import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import java.util.TreeMap;
import java.util.TreeSet;

import com.toyspace.product.model.vo.Product;
import com.toyspace.product.model.vo.Tags;

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
	//////////////////////////////////////////////////////////////
	//////////////////공용////////////////////////////////////////
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
	
	public Product productConvention(ResultSet rs) throws SQLException{
		Product p=new Product();
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
		
		return p;
	}
	
	
	public TreeMap<Integer, Integer> categoryQtyTreeMapConvention() {
	
		TreeMap<Integer, Integer> categoryQty = new TreeMap<Integer, Integer>();
		for(int i =1; i<6; i++) {
			categoryQty.put(i, 0);
		}
		return categoryQty;
	}
	
	////////////////////////////////////////////////////////////////
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
				Product p=productConvention(rs);
				p.setCategoryName(rs.getString("category_name"));
				
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
				p=productConvention(rs);
				
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
	public boolean updateProduct(Connection conn, Product p) {
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
		return result==1;
	}
	
	public boolean removeProductTags(Connection conn, int productId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("removeProductTags"));
			pstmt.setInt(1, productId);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			result=0;
		} finally {
			close(pstmt);
		}
		
		return result!=0;
	}
	
	public boolean updateProductTags(Connection conn, int productId, String[] tagsArr) {
		
		PreparedStatement pstmt = null;
		int[] result = new int[0];
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateProductTags"));
			for(String v : tagsArr) {
				pstmt.setInt(1, productId);
				pstmt.setInt(2, Integer.parseInt(v));
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			result = pstmt.executeBatch();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result.length==tagsArr.length;
	}
	
	public boolean removeProduct(Connection conn, String[] productIds) {
		PreparedStatement pstmt = null;
		int[] result = new int[0];
		try {
			pstmt = conn.prepareStatement(prop.getProperty("removeProduct"));
			for(String v : productIds) {
				pstmt.setInt(1, Integer.parseInt(v));
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			result = pstmt.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result.length==productIds.length;
	}
//관리자용 상품찾기 	
	public ArrayList<Product> searchProductList(Connection conn, String searchKeyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Product> productsList= new ArrayList<Product>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchProductList"));
			pstmt.setString(1, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			while(rs.next()){		
				Product p = productConvention(rs);	
				productsList.add(p);
			}
			Collections.sort(productsList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productsList;
	}
	
	public ArrayList<Product> loadAllProductsWithMainPic(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Product> productsList=new ArrayList<Product>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loadAllProductsWithMainPic"));
			
			  pstmt.setInt(1, (cPage-1)*numPerPage+1); 
			  pstmt.setInt(2, cPage*numPerPage);
			 
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product p=productConvention(rs);
				p.setCategoryName(rs.getString("category_name"));
				
				ArrayList<String> mainPicPath =new ArrayList<String>();
				mainPicPath.add(rs.getNString("IMAGE_ROUTE"));
				p.setProductImageFilePaths(mainPicPath);
				
				productsList.add(p);
			}
			 Collections.sort(productsList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return productsList;
	}
	
	
	public ArrayList<Product> searchByCategoryAndKeyword(Connection conn, String[] categoryNumbers,String searchKeyword , int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Product> productsList=new ArrayList<Product>();
		try {
			String sql = prop.getProperty("searchByCategoryAndKeywordHead");
			for(int i = 0; i<categoryNumbers.length;i++) {
				if(i!=categoryNumbers.length-1) sql +=categoryNumbers[i]+", ";
				else sql+=categoryNumbers[i];
			}
			sql += prop.getProperty("searchByCategoryAndKeywordTail");
			pstmt=conn.prepareStatement(sql);
			pstmt.setNString(1,"%"+searchKeyword+"%");
			pstmt.setNString(2,"%"+searchKeyword+"%");
			pstmt.setNString(3,"%"+searchKeyword+"%");
			pstmt.setInt(4, (cPage-1)*numPerPage+1); 
			pstmt.setInt(5, cPage*numPerPage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Product p=new Product();		
				p.setProductId(rs.getInt("product_id"));
				p.setCategoryNo(rs.getInt("category_no"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getDouble("product_price"));
				productsList.add(p);

			}
			Collections.sort(productsList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return productsList;
	}

//메인에서(고객용) 제품검색
	public ArrayList<Product> searchByKeyword(Connection conn, String searchKeyword, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Product> productsList= new ArrayList<Product>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchByKeyword"));
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setString(3, "%"+searchKeyword+"%");
			pstmt.setInt(4, (cPage-1)*numPerPage+1); 
			pstmt.setInt(5, cPage*numPerPage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Product p=new Product();		
				p.setProductId(rs.getInt("product_id"));
				p.setCategoryNo(rs.getInt("category_no"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getDouble("product_price"));
				productsList.add(p);

			}
			Collections.sort(productsList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productsList;
	}
	
	
	public String loadMainPicForProduct(Connection conn, int productId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String imageFile=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectImageFile"));
			pstmt.setInt(1, productId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				imageFile=rs.getString(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return imageFile;
		
	}
	

	
	public Product loadSelectedProductWithMainPic(Connection conn, int productId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product p = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadSelectedProductWithMainPic"));
			pstmt.setInt(1, productId);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				p = productConvention(rs);
				ArrayList<String> mainPicPath =new ArrayList<String>();
				mainPicPath.add(rs.getNString("IMAGE_ROUTE"));
				p.setProductImageFilePaths(mainPicPath);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}
	public int selectProductCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
	public int selectProductCountByKeyword(Connection conn, String searchKeyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductCountByKeyword"));
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setString(3, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public TreeMap<Integer, Integer> loadCategoryQty(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TreeMap<Integer, Integer> categoryQty = categoryQtyTreeMapConvention();
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadCategoryQty"));
			rs=pstmt.executeQuery();
				
			while(rs.next()) {
				categoryQty.put(rs.getInt("CATEGORY_NO"),rs.getInt("SUM_CAT"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return categoryQty;
	}
	
	public TreeMap<Integer, Integer> loadCategoryQty(Connection conn, String searchKeyword){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TreeMap<Integer, Integer> categoryQty = categoryQtyTreeMapConvention();
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadCategoryQtyWithKeyword"));
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setString(3, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
				
			while(rs.next()) {
				categoryQty.put(rs.getInt("CATEGORY_NO"),rs.getInt("SUM_CAT"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return categoryQty;
	}
	public TreeMap<Integer, Integer> loadCategoryQty(Connection conn, String[] categoryNumbers, String searchKeyword){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TreeMap<Integer, Integer> categoryQty = categoryQtyTreeMapConvention();
		
		try {
			String sql = prop.getProperty("loadCategoryQtyWithCategoryAndKeywordHead")+ prop.getProperty("searchByCategoryAndKeywordHead");
			for(int i = 0; i<categoryNumbers.length;i++) {
				if(i!=categoryNumbers.length-1) sql +=categoryNumbers[i]+", ";
				else sql+=categoryNumbers[i];
			}
			sql+=prop.getProperty("loadCategoryQtyWithCategoryAndKeywordTail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setString(3, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
				
			while(rs.next()) {
				categoryQty.put(rs.getInt("CATEGORY_NO"),rs.getInt(2));
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return categoryQty;
	}
}
