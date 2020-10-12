package com.toyspace.product.model.dao;

import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TreeSet;

import com.toyspace.product.model.vo.Tags;

public class TagDao {

	private Properties prop=new Properties();
	
	public TagDao() {
		try {
			String path=TagDao.class.getResource("/sql/tag/tag_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
//태그추가	
	public int insertTag(Connection conn, Tags t) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertTag"));
			pstmt.setString(1, t.getTagName());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//	모든 태그 불러오는 메소드. 범용 가능
	public TreeSet<Tags> loadAllTags(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TreeSet<Tags> tagsList = new TreeSet<Tags>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loadAllTags"));
			rs=pstmt.executeQuery();
			while(rs.next()){
				Tags t = new Tags(rs.getInt(1), rs.getNString(2));
				tagsList.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return tagsList;
	}
//태그삭제
	public int deleteTag(Connection conn, String tagName) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteTag"));
			pstmt.setString(1, tagName);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//태그찾기
	public TreeSet<Tags> searchTagList(Connection conn, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		TreeSet<Tags> tagsList= new TreeSet<Tags>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchTagList"));
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			while(rs.next()){
				Tags t = new Tags(rs.getInt(1), rs.getNString(2));
				tagsList.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return tagsList;
	}
	public int editTag(Connection conn, Tags t) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("editTag"));
			pstmt.setString(1, t.getTagName());
			pstmt.setInt(2, t.getTagNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//상품의 태그 가져오기 
	public TreeSet<Tags> itemTags(Connection conn, String productId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		TreeSet<Tags> tagsList= new TreeSet<Tags>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("itemTags"));
			pstmt.setString(1, productId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Tags t = new Tags();
				t.setTagNo(rs.getInt("tag_no"));
				t.setTagName(rs.getString("tag_name"));
				tagsList.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return tagsList;
	}

}
