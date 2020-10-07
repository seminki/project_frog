package com.toyspace.admin.model.service;

import java.sql.Connection;
import static com.toyspace.common.JDBCTemplate.*;

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
	
}
