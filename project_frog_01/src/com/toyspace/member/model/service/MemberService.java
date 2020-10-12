package com.toyspace.member.model.service;

import java.sql.Connection;

import static com.toyspace.common.JDBCTemplate.*;
import com.toyspace.member.model.dao.MemberDao;
import com.toyspace.member.model.vo.Member;
import com.toyspace.member.model.vo.SNSLogin;

public class MemberService {

	private MemberDao dao = new MemberDao();
	
	public MemberService() {
		// TODO Auto-generated constructor stub
	}
////////////////////////////////////////////////////////////////////////////
//////////////////////////공용부////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
	public void insertLoginLog(Connection conn, Member m, int signInSource) {
		if(m==null) return;
		else {
			boolean result = dao.insertLoginLog(conn, m.getMemberKey(), signInSource);
			if(!result) System.out.println("로그 생성에 실패했습니다.");
		}
	}
///////////////////////////////////////////////////////////////////////////
	public Member checkMemberThroughSNSId(int signInSource, String id) {
		Connection conn = getConnection();
		Member m =dao.checkMemberThroughSNSId(conn, signInSource, id);
		insertLoginLog(conn, m, signInSource);
		close(conn);
		return m;
	}
	
	public Member checkMemberThroughSNSEmail(String email) {
		Connection conn = getConnection();
		Member m =dao.checkMemberThroughSNSEmail(conn, email);
		close(conn);
		return m;
	}
	
	public Member signUpThroughSNS(Member newMember, SNSLogin sns) {
		Connection conn = getConnection();
		int memberKey = dao.memberKeySequenceNextValue(conn);
//		memberKeySequenceNextValue를 통해 생성된 멤버키를 newMember에 넣어줌!
		newMember.setMemberKey(memberKey);

		boolean result = dao.signUpThroughSNS(conn, newMember, sns.getLoginSourceDescription());
		if(!result) {
			rollback(conn);
			System.out.println("멤버 저장에 실패했습니다");
			return null;
		}
		
		
//		memberKeySequenceNextValue를 통해 생성된 멤버키를 sns에 넣어줌!
		sns.setMemberKey(memberKey);
		result = dao.insertSNSInfo(conn, sns);
		if(!result) {
			rollback(conn);
			System.out.println("SNS 정보 저장에 실패했습니다.");
			return null;
		}
		
		commit(conn);
		
		Member m = dao.loadMemberByMemberKey(conn, memberKey);
		insertLoginLog(conn, m, sns.getLoginSourceNo());
		close(conn);
		
		return m;
	}
	
	public boolean passwordCheck(int memberKey, String password) {
		Connection conn = getConnection();
		boolean result = dao.passwordCheck(conn, memberKey, password);
		close(conn);
		return result;
	}
	
	public boolean insertSNSInfoToExistingMember(Member m, SNSLogin sns) {
		
		Connection conn = getConnection();
		
		sns.setMemberKey(m.getMemberKey());
		
		boolean result = dao.insertSNSInfo(conn, sns);
		insertLoginLog(conn, m, sns.getLoginSourceNo());
		
		
		if(!result) rollback(conn);
		else commit(conn); 
			
		close(conn);
		
		return result;
	}
}
