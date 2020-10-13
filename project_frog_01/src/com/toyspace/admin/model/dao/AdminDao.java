package com.toyspace.admin.model.dao;

import static com.toyspace.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
//	private String adminId;
//	private String adminPassword;
//	private String nickname;
//	private String adminName;
//	private int adminLevel;
//	private String adminLevelDescription;
	public Admin adminConvention(ResultSet rs) throws SQLException{
		Admin admin=new Admin();
		admin.setAdminId(rs.getString("ADMIN_ID"));
		admin.setAdminPassword(rs.getString("ADMIN_PASSWORD"));
		admin.setNickname(rs.getString("ADMIN_NICKNAME"));
		admin.setAdminName(rs.getString("ADMIN_NAME"));
		admin.setAdminLevel(rs.getInt("ADMIN_LEVEL"));
		return admin;
	}
	
	public ArrayList<Admin> loadAllAdmin(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Admin> adminList=new ArrayList<Admin>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("loadAllAdmin"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Admin admin=adminConvention(rs);
				
				adminList.add(admin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return adminList;
	}
	public boolean insertAdmin(Connection conn,Admin a) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertAdmin"));
			pstmt.setString(1,a.getAdminId());
			pstmt.setString(2,a.getAdminPassword());
			pstmt.setString(3,a.getNickname());
			pstmt.setString(4,a.getAdminName());
			pstmt.setInt(5,a.getAdminLevel());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result==1;
	}
	//관리자 계정 삭제
	public boolean deleteAdmin(Connection conn, String adminId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteAdmin"));
			pstmt.setNString(1,adminId);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result==1;
	}
	public boolean editAdmin(Connection conn,Admin a) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("editAdmin"));
			pstmt.setString(1,a.getAdminPassword());
			pstmt.setString(2,a.getNickname());
			pstmt.setString(3,a.getAdminName());
			pstmt.setInt(4,a.getAdminLevel());
			pstmt.setString(5,a.getAdminId());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result==1;
	}
	
}
