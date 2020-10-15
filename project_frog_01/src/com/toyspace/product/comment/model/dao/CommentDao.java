package com.toyspace.product.comment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
