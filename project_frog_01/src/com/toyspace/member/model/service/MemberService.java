package com.toyspace.member.model.service;

import static com.toyspace.common.JDBCTemplate.close;
import static com.toyspace.common.JDBCTemplate.commit;
import static com.toyspace.common.JDBCTemplate.getConnection;
import static com.toyspace.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.toyspace.admin.model.vo.Admin;
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
	
	public int insertMember(Member m) {
	      Connection conn = getConnection();
	      int memberKey = dao.memberKeySequenceNextValue(conn);
	      m.setMemberKey(memberKey);
	      int result= dao.insertMember(conn, m);
	      if(result>0) commit(conn);
	      else rollback(conn);
	      close(conn);
	      return result;
	   }
	public int memberInfoChange(Member m) {
		Connection conn = getConnection();
		int result= dao.memberInfoChange(conn, m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public Member loadMembers(String userId, String userPw) {
		Connection conn =  getConnection();
		Member member= dao.loadMembers(conn, userId, userPw);
		close(conn);
		return member;
	}
	
//관리자페이지 멤버리스트 
	public ArrayList<Member> loadAllMemberList() {
		Connection conn=getConnection();
		ArrayList<Member> memberList=dao.loadAllMemberList(conn);
		close(conn);
		return memberList;
	}
	public ArrayList<Member> searchMemberList(String type, String key) {
		Connection conn=getConnection();
		ArrayList<Member> memberList=dao.searchMemberList(conn, type, key);
		close(conn);
		return memberList;
	}
	
}
