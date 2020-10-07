package com.toyspace.admin.model.dao;

import static com.toyspace.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.toyspace.admin.model.vo.Admin;

public class AdminDao {
	
	private Properties prop = new Properties();
	
	public AdminDao() {
		
		try {
			String path = AdminDao.class.getResource("/sql/admin/admin_sql.properties").getPath();
			prop.load(new FileReader(path));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Admin loadMember(Connection conn, String adminId, String adminPw) {
		Admin admin=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadAdmin"));
			
			pstmt.setNString(1, adminId);
			pstmt.setNString(2, adminPw);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				admin=new Admin(rs.getNString(2), 
						rs.getNString(3), rs.getNString(4), 
						rs.getNString(5), rs.getInt(1), 
						rs.getNString(6));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return admin;
	}
	
	
	
}
