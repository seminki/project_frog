package com.toyspace.member.model.service;

import java.sql.Connection;

import static com.toyspace.common.JDBCTemplate.*;
import com.toyspace.member.model.dao.MemberDao;
import com.toyspace.member.model.vo.Member;

public class MemberService {

	private MemberDao dao = new MemberDao();
	
	public MemberService() {
		// TODO Auto-generated constructor stub
	}
	
	public Member checkMemberThroughSNSId(int signInSource, String id) {
		Connection conn = getConnection();
		Member m =dao.checkMemberThroughSNSId(conn, signInSource, id);
		close(conn);
		return m;
	}
}
