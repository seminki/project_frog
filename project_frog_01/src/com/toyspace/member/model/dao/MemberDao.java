package com.toyspace.member.model.dao;


import static com.toyspace.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.toyspace.admin.model.vo.Admin;
import com.toyspace.member.model.vo.Member;
import com.toyspace.member.model.vo.SNSLogin;

public class MemberDao {
 
	private Properties prop = new Properties();
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
		try {
			String path = MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
			prop.load(new FileReader(path));
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////
//////////////////////////공용부////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
//	간단하게 이것만 while문 안에 넣어주면 멤버를 받아올 수 있음!
	public Member memberConvention(ResultSet rs) throws Exception{
		Member m =new Member();
		
		m.setMemberKey(rs.getInt("MEMBER_KEY"));
		m.setUserId(rs.getString("USER_ID"));
		m.setUserEmail(rs.getNString("USER_EMAIL"));
		m.setPassword(rs.getString("USER_PASSWORD"));
		m.setUserGender(rs.getString("USER_GENDER"));
		m.setUserName(rs.getNString("USER_NAME"));
		m.setUserNickname(rs.getNString("USER_NICKNAME"));
		m.setUserAge(rs.getInt("USER_AGE"));
		m.setUserBirthday(rs.getNString("USER_BIRTHDAY"));
		m.setUserAddress(rs.getNString("USER_ADDRESS"));
		m.setUserPhone(rs.getNString("USER_PHONE"));
		m.setUserSignUpDate(rs.getDate("USER_SIGN_UP_DATE"));
		m.setUserProfilePicPath(rs.getNString("USER_PROFILE_PIC_PATH"));
		m.setUserMileage(rs.getInt("USER_MILEAGE"));
		m.setMemberLevelNo(rs.getInt("MEMBER_LEVEL_NO"));
		m.setModifiedDate(rs.getDate("MODIFIED_DATE"));
		m.setUserProfilePicUrl(rs.getNString("USER_PROFILE_PIC_URL"));
		
		return m;
	}
	
	public int memberKeySequenceNextValue(Connection conn) {
		int nextValue=0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("memberKeySequenceNextValue"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				nextValue=rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("멤버키 시퀀스 밸류 로드 실패");
		}finally {
			close(rs);
			close(pstmt);
		}
		return nextValue;
	}
	
	public boolean insertLoginLog(Connection conn, int memberKey, int signInSource) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertLoginLog"));
			pstmt.setInt(1, memberKey);
			pstmt.setInt(2, signInSource);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("MemberDao에서 로그인 로그 생성 실패");
		} finally {
			close(pstmt);
		}
		
		return result==1;
	}
	
	
///////////////////////////////////////////////////////////////////////////////
	
	public Member checkMemberThroughSNSId(Connection conn, int signInSource, String id) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rsSize=0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("checkMemberThroughSNSId"));
			pstmt.setInt(1, signInSource);
			pstmt.setNString(2, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				m = memberConvention(rs);
				rsSize++;
			}
			if(rsSize!=1) m = null;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m = null;
			if(rsSize>1) System.out.println("조회된 회원이 한명 이상입니다!!");
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return m;
	}
	
	public Member checkMemberThroughSNSEmail(Connection conn, String email) {
		Member m =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rsSize=0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("checkMemberThroughSNSEmail"));
			pstmt.setNString(1, email);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				m = memberConvention(rs);
				rsSize++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m = null;
			if(rsSize>1) System.out.println("조회된 회원이 한명 이상입니다!!");
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public boolean signUpThroughSNS(Connection conn, Member newMember, String loginSourceDescription) {
		int result=0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("signUpThroughSNS"));
			
			pstmt.setInt(1, newMember.getMemberKey());
//			아이디는 currentTimeMillis로 생성
			pstmt.setString(2, loginSourceDescription+"_"+System.currentTimeMillis());
			pstmt.setNString(3, newMember.getUserEmail());
			pstmt.setNString(4, newMember.getUserName());
			
			if(newMember.getUserNickname()!=null) pstmt.setNString(5, newMember.getUserNickname());
			else pstmt.setNString(5, loginSourceDescription+"_"+System.currentTimeMillis());
			
			pstmt.setNString(6, newMember.getUserBirthday());
			pstmt.setNString(7, newMember.getUserProfilePicUrl());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("MemberDao에서 SNS를 통한 회원가입에 실패!");
		} finally {
			close(pstmt);
		}

		return result==1;
	}
	
	public boolean insertSNSInfo(Connection conn, SNSLogin sns) {
		int result =0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt= conn.prepareStatement(prop.getProperty("insertSNSInfo"));
			pstmt.setInt(1, sns.getMemberKey());
			pstmt.setInt(2, sns.getLoginSourceNo());
			pstmt.setNString(3, sns.getSnsId());
			pstmt.setNString(4, sns.getSnsName());
			pstmt.setString(5, sns.getSnsProfile());
			pstmt.setString(6, sns.getAccessToken());
			pstmt.setNString(7, sns.getRefreshToken());
			pstmt.setDate(8, sns.getRefreshTokenValidDate());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("MemberDao에서 SNS 로그인 정보 삽입에 실패!!");
		} finally {
			close(pstmt);
		}
		
		return result==1;
	}
	
	public Member loadMemberByMemberKey(Connection conn, int memberKey) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadMemberByMemberKey"));
			pstmt.setInt(1, memberKey);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				m=memberConvention(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m=null;
			System.out.println("멤버를 멤버키로 불러오기 실패!");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return m;
	}
	
	public boolean passwordCheck(Connection conn, int memberKey, String password) {
		int result= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("passwordCheck"));
			pstmt.setInt(1, memberKey);
			pstmt.setNString(2, password);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("passwordCheck : 패스워드가 일치하지 않습니다");
		} finally {
			close(rs);
			close(pstmt);
		}
		return result ==1;
	}
			////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////회원가입//////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////

	public int insertMember(Connection conn,Member m) {
	      PreparedStatement pstmt = null;
	      int result=0;
	      
	      try {
	         pstmt=conn.prepareStatement(prop.getProperty("insertMember"));         
	         pstmt.setInt(1,m.getMemberKey());
	         pstmt.setString(2, m.getUserId());
	         pstmt.setString(3,m.getUserEmail());
	         pstmt.setString(4,m.getPassword());      
	         pstmt.setString(5,m.getUserGender());               
	         pstmt.setString(6,m.getUserName());
	         pstmt.setString(7,m.getUserNickname());    
	         result=pstmt.executeUpdate();

	      }catch(Exception e) {
	         e.printStackTrace();
	         System.out.println("dao 레벨에서 멤버 인서트에 실패!");
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }
	public int memberInfoChange(Connection conn,Member m) {
		PreparedStatement pstmt = null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("memberInfoChange"));         
			pstmt.setInt(1,m.getMemberKey());
			pstmt.setString(2,m.getUserEmail());
			pstmt.setString(3,m.getPassword());      
			pstmt.setString(4,m.getUserGender());               
			pstmt.setString(5,m.getUserName());
			pstmt.setString(6,m.getUserNickname());    
			
			pstmt.setInt(7,m.getUserAge());    
			pstmt.setString(8,m.getUserBirthday());    
			pstmt.setString(9,m.getUserPhone());    
			pstmt.setString(10,m.getUserId());
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("dao 레벨에서 멤버 업데이트 실패!");
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Member loadMembers(Connection conn, String memberId, String memberPw) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("loadMember"));
			
			pstmt.setNString(1, memberId);
			pstmt.setNString(2, memberPw);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member(rs.getInt("MEMBER_KEY"),rs.getString("USER_ID"),rs.getString("USER_EMAIL"),rs.getString("USER_PASSWORD"),
						rs.getString("USER_GENDER"),rs.getString("USER_NAME"),rs.getString("USER_NICKNAME"),rs.getInt("USER_AGE"),
						rs.getString("USER_BIRTHDAY"),rs.getString("USER_ADDRESS"),rs.getString("USER_PHONE"),rs.getDate("USER_SIGN_UP_DATE"),
						rs.getString("USER_PROFILE_PIC_PATH"),rs.getInt("USER_MILEAGE"),rs.getString("RECOVERY_PASSWORD"),rs.getInt("MEMBER_LEVEL_NO"),
						rs.getDate("MODIFIED_DATE"),null, rs.getString("USER_PROFILE_PIC_URL"));
				
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("오류발생");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}
		
	//멤버 리스트
		public ArrayList<Member> loadAllMemberList(Connection conn) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Member m=null;
			ArrayList<Member> memberList=new ArrayList<Member>();
			try {
				pstmt=conn.prepareStatement(prop.getProperty("loadAllMember"));
				rs=pstmt.executeQuery();
				while(rs.next()) {
					m=memberConvention(rs);
					
					memberList.add(m);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return memberList;
		}
//관리자용-멤버 이름/아이디 조회하기
		public ArrayList<Member> searchMemberList(Connection conn, String type, String key) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Member m= null;
			ArrayList <Member> memberList=new ArrayList();
			try {
				String sql=prop.getProperty("searchMemberList").replaceAll("@type", type);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "%"+key+"%");
				rs=pstmt.executeQuery();
				while(rs.next()) {
					m=memberConvention(rs);
					memberList.add(m);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return memberList;
		}
	
	
	
	
	
	
}