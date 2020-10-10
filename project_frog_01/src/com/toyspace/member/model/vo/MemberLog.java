package com.toyspace.member.model.vo;

import java.util.Date;

public class MemberLog {
	
	private Date loginDate;
	private int loginStatusNo;
	private String loginStatusDescription;
	private int loginSourceNo;
	private String loginSourceDescription;
	
	public MemberLog() {
		// TODO Auto-generated constructor stub
	}

	public MemberLog(Date loginDate, int loginStatusNo, String loginStatusDescription, int loginSourceNo,
			String loginSourceDescription) {
		super();
		this.loginDate = loginDate;
		this.loginStatusNo = loginStatusNo;
		this.loginStatusDescription = loginStatusDescription;
		this.loginSourceNo = loginSourceNo;
		this.loginSourceDescription = loginSourceDescription;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public int getLoginStatusNo() {
		return loginStatusNo;
	}

	public void setLoginStatusNo(int loginStatusNo) {
		this.loginStatusNo = loginStatusNo;
	}

	public String getLoginStatusDescription() {
		return loginStatusDescription;
	}

	public void setLoginStatusDescription(String loginStatusDescription) {
		this.loginStatusDescription = loginStatusDescription;
	}

	public int getLoginSourceNo() {
		return loginSourceNo;
	}

	public void setLoginSourceNo(int loginSourceNo) {
		this.loginSourceNo = loginSourceNo;
	}

	public String getLoginSourceDescription() {
		return loginSourceDescription;
	}

	public void setLoginSourceDescription(String loginSourceDescription) {
		this.loginSourceDescription = loginSourceDescription;
	}

	@Override
	public String toString() {
		return "MemberLog [loginDate=" + loginDate + ", loginStatusNo=" + loginStatusNo + ", loginStatusDescription="
				+ loginStatusDescription + ", loginSourceNo=" + loginSourceNo + ", loginSourceDescription="
				+ loginSourceDescription + "]";
	}
	
	
}
