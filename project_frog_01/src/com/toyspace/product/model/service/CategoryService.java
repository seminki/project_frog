package com.toyspace.product.model.service;

import java.sql.Connection;
import java.util.TreeSet;
import static com.toyspace.common.JDBCTemplate.*;


import com.toyspace.product.model.dao.CategoryDao;
import com.toyspace.product.model.vo.Category;

public class CategoryService {
	
	private CategoryDao dao = new CategoryDao();
	
	public CategoryService() {
		// TODO Auto-generated constructor stub
	}
//	모든 카테고리 불러오기
	public TreeSet<Category> loadAllCategories(){
		Connection conn = getConnection();
		TreeSet<Category> categoryList = dao.loadAllCategories(conn);
		close(conn);
		return categoryList;
	}
	
}
