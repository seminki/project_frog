package com.toyspace.admin.model.service;

import static com.toyspace.common.JDBCTemplate.close;
import static com.toyspace.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.toyspace.admin.model.dao.AdminDao;
import com.toyspace.admin.model.vo.Admin;

public class AdminService {

	private AdminDao dao = new AdminDao();
	
	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin loadMember(String adminId, String adminPw) {
		Connection conn =  getConnection();
		Admin admin= dao.loadMember(conn, adminId, adminPw);
		close(conn);
		return admin;
	}
	
	//admin 계정 리스트
	public ArrayList<Admin> loadAllAdmin(){
		Connection conn=getConnection();
		ArrayList<Admin> adminList=dao.loadAllAdmin(conn);
		close(conn);
		return adminList;
		
	}
	
}
