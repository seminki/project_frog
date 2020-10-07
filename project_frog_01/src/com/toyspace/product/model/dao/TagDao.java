package com.toyspace.product.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import static com.toyspace.common.JDBCTemplate.close;

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

}
