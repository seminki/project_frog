package com.toyspace.member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import static com.toyspace.common.JDBCTemplate.*;

import com.toyspace.member.model.vo.Member;

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
	
	public Member checkMemberThroughSNSId(Connection conn, int signInSource, String id) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("checkMemberThroughSNSId"));
			pstmt.setInt(1, signInSource);
			pstmt.setNString(2, id);
			rs=pstmt.executeQuery();
			
			int rsSize=0;
			while(rs.next()) {
				m = new Member();
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
				m.setMemberLevelDescription(rs.getNString("MEMBER_LEVEL_DESCRIPTION"));
				m.setModifiedDate(rs.getDate("MODIFIED_DATE"));
				m.setUserProfilePicUrl(rs.getNString("USER_PROFILE_PIC_URL"));
				rsSize++;
			}
			if(rsSize!=1) m = null;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m = null;
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return m;
	}
}
