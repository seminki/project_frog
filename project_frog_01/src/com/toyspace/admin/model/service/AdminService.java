package com.toyspace.admin.model.service;

import static com.toyspace.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.toyspace.admin.model.dao.AdminDao;
import com.toyspace.admin.model.vo.Admin;
import com.toyspace.member.model.vo.Member;

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
	
	public boolean insertAdmin(Admin admin) {
		Connection conn = getConnection();
		boolean result = dao.insertAdmin(conn, admin);
		if(result) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	//관리자 계정 삭제
	public boolean deleteAdmin(String adminId) {
		Connection conn=getConnection();
		boolean result=dao.deleteAdmin(conn,adminId);
		if(result) commit(conn);
		else rollback(conn);
		close(conn);
		
		
		
		return result;
	}
	public boolean editAdmin(Admin admin) {
		Connection conn = getConnection();
		boolean result = dao.editAdmin(conn,admin);
		if(result) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	
	public boolean selectedAdminRemove(String[] adminIds) {
		Connection conn=getConnection();
		boolean result = false;
		for(String adminId : adminIds) {
			result=dao.deleteAdmin(conn,adminId);
			if(!result) {
				rollback(conn);
				close(conn);
				return result;
			}
		}
		commit(conn);
		close(conn);
		return result;
	}

}
