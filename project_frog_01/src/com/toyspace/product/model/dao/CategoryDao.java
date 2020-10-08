package com.toyspace.product.model.dao;

import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.TreeSet;

import com.toyspace.product.model.vo.Category;

public class CategoryDao {
	
private Properties prop=new Properties();
	
	public CategoryDao() {
		try {
			String path=CategoryDao.class.getResource("/sql/category/category_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
//	모든 카테고리 불러오기
	public TreeSet<Category> loadAllCategories(Connection conn){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TreeSet<Category> categoryList = new TreeSet<Category>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loadAllCategories"));
			rs=pstmt.executeQuery();
			while(rs.next()){
				Category c = new Category(rs.getInt(1), rs.getNString(2));
				categoryList.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return categoryList;
	}
}
