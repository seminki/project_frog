package com.toyspace.product.model.service;

import static com.toyspace.common.JDBCTemplate.close;
import static com.toyspace.common.JDBCTemplate.commit;
import static com.toyspace.common.JDBCTemplate.getConnection;
import static com.toyspace.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.toyspace.product.model.dao.ProductDao;
import com.toyspace.product.model.vo.Product;

public class ProductService {

	private ProductDao dao =new ProductDao();
	
	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertProduct(Product insertion, List<Integer> tagsList) {
		boolean result = false;
		
		Connection conn = getConnection();
		int productId =dao.nextSeq(conn);
		if(productId==-1) {
			rollback(conn);
			close(conn);
			return result;
		}
		result = dao.insertProduct(conn, productId, insertion);
		if(!result) {
			rollback(conn);
			close(conn);
			return false;
		}
		
		result = dao.insertFilePathsIntoProduct(conn, productId, insertion.getProductImageFilePaths());
		if(!result) {
			rollback(conn);
			close(conn);
			return false;
		}
		
		result = dao.insertTagsIntoProduct(conn, productId, tagsList);
		if(result) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
//상품리스트 (관리자:상품관리페이지)
	public ArrayList<Product> loadAllproducts() {
		Connection conn=getConnection();
		ArrayList<Product> productsList=dao.loadAllProducts(conn);
		close(conn);
		return productsList;
	}
//상품정보 불러오기(관리자:상품수정페이지용)
	public Product productInfo(String productId) {
		Connection conn=getConnection();
		Product p=dao.productInfo(conn,productId);
		p.setProductImageFilePaths(dao.loadImageFilePaths(conn, productId));
		close(conn);
		return p;
	}
//상품수정
	public boolean updateProduct(Product p, String[] tagsArr) {
		Connection conn=getConnection();
		int productId = p.getProductId();
		boolean result=dao.updateProduct(conn,p);
		if(!result) {
			rollback(conn);
			System.out.println("상품 업데이트 실패!");
			close(conn);
			return result;
		}
		result = dao.removeProductTags(conn, productId);
		if(!result) {
			rollback(conn);
			System.out.println("상품의 태그들 삭제 실패!");
			close(conn);
			return result;
		}
		result = dao.updateProductTags(conn, productId,tagsArr);
		if(!result) {
			rollback(conn);
			System.out.println("상품의 태그들 업데이트 실패!");
			close(conn);
			return result;
		}
		commit(conn);
		close(conn);
		return result;
	}
	
	public boolean removeProduct(String[] productIds) {
		Connection conn = getConnection();
		boolean result = dao.removeProduct(conn, productIds);
		
		if(!result) rollback(conn);
		else commit(conn);
		
		close(conn);
		return result;
		
	}
	
	public ArrayList<Product> searchProductList(String searchKeyword){
		
		Connection conn=getConnection();
		ArrayList<Product> productsList =dao.searchProductList(conn,searchKeyword);
		close(conn);
		return productsList;
	}
	
	
	public ArrayList<Product> loadAllProductsWithMainPic(int cPage, int numPerPage) {
		Connection conn=getConnection();
		ArrayList<Product> productsList=dao.loadAllProductsWithMainPic(conn,cPage,numPerPage);
		close(conn);
		return productsList;
	}


//메인에서 제품검색
	public ArrayList<Product> searchByKeyword(String searchKeyword, int cPage, int numPerPage) {
		Connection conn=getConnection();
		ArrayList<Product> productsList =dao.searchByKeyword(conn,searchKeyword, cPage, numPerPage);
		for(Product p : productsList) {
			ArrayList<String> filePaths = new ArrayList<String>();
			filePaths.add(dao.loadMainPicForProduct(conn,p.getProductId()));
			p.setProductImageFilePaths(filePaths);
		}
		return productsList;
	}

	public TreeMap<Integer, Product> loadSelectedProductsWithMainPic(TreeMap<Integer, Integer> cartValues){
		Connection conn = getConnection();
		TreeMap<Integer, Product> productInCart = new TreeMap<Integer, Product>();
		for(int productId: cartValues.keySet()) {
			productInCart.put(productId, dao.loadSelectedProductWithMainPic(conn,productId));
		}
		close(conn);
		
		return productInCart;

	}
	public ArrayList<Product> searchByCategoryAndKeyword(String[] categoryNumbers, String searchKeyword, int cPage, int numPerPage) {
		Connection conn=getConnection();
		
		ArrayList<Product> productsList=dao.searchByCategoryAndKeyword(conn,categoryNumbers, searchKeyword, cPage, numPerPage);
		for(Product p : productsList) {
			ArrayList<String> filePaths = new ArrayList<String>();
			filePaths.add(dao.loadMainPicForProduct(conn,p.getProductId()));
			p.setProductImageFilePaths(filePaths);
		}
		close(conn);
		return productsList;

	}
	public int selectProductCount() {
		Connection conn=getConnection();
		int count=dao.selectProductCount(conn);
		close(conn);
		return count;
	}
	
	public int selectProductCountByKeyword(String searchKeyword) {
		Connection conn =getConnection();
		int count = dao.selectProductCountByKeyword(conn, searchKeyword);
		close(conn);
		return count;
	}
	
	public TreeMap<Integer, Integer> loadCategoryQty(){
		Connection conn = getConnection();
		TreeMap<Integer, Integer> categoryQty = dao.loadCategoryQty(conn);
		close(conn);
		return categoryQty;
	}
	
	public TreeMap<Integer, Integer> loadCategoryQty(String searchKeyword){
		Connection conn = getConnection();
		TreeMap<Integer, Integer> categoryQty = dao.loadCategoryQty(conn, searchKeyword);
		close(conn);
		return categoryQty;
	}
	
	public TreeMap<Integer, Integer> loadCategoryQty(String[] categoryNumbers, String searchKeyword){
		Connection conn = getConnection();
		TreeMap<Integer, Integer> categoryQty = dao.loadCategoryQty(conn, categoryNumbers, searchKeyword);
		close(conn);
		return categoryQty;
	}
	
}
