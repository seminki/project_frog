package com.toyspace.product.comment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.toyspace.common.JDBCTemplate.close;

import com.toyspace.product.comment.model.vo.Comment;

public class CommentDao {
	
	private Properties prop=new Properties();
	
	public CommentDao(){
		try {
			String path=CommentDao.class.getResource("/sql/comment/comment_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public int insertComment(Connection conn, Comment c) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertComment"));
			pstmt.setInt(1,c.getProductId());
			pstmt.setInt(2,c.getMemberKey());		
			pstmt.setInt(3,c.isSecret()?1:0);
			pstmt.setInt(4,c.isDeleted()?1:0);
			pstmt.setString(5, c.getCommentContent());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public List<Comment> loadProductComment(Connection conn, String productId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Comment> commentList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loadProductComment"));
			pstmt.setString(1,productId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Comment c=new Comment();
				c.setProductCommentNo(rs.getInt("product_comment_no"));
				c.setProductId(rs.getInt("product_id"));
				c.setMemberKey(rs.getInt("member_key"));
				c.setCommentRefNo(rs.getInt("comment_ref_no"));
				c.setSecret(rs.getBoolean("is_secret"));
				c.setDeleted(rs.getBoolean("is_deleted"));
				c.setCommentContent(rs.getString("comment_content"));
				c.setCommentDate(rs.getDate("comment_date"));
				c.setUserId(rs.getString("user_id"));
				c.setUserNickname(rs.getString("user_nickname"));
				commentList.add(c);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return commentList;
	}

}
