package com.toyspace.member.model.vo;

import java.util.Date;

public class SNSLogin {
	
	private int memberKey;
	private int loginSourceNo;
	private String loginSourceDescription;
	private String snsId;
	private String snsName;
	private String snsProfile;
	private Date snsConnectDate;
	
	public SNSLogin() {
		// TODO Auto-generated constructor stub
	}

	public SNSLogin(int memberKey, int loginSourceNo, String loginSourceDescription, String snsId, String snsName,
			String snsProfile, Date snsConnectDate) {
		super();
		this.memberKey = memberKey;
		this.loginSourceNo = loginSourceNo;
		this.loginSourceDescription = loginSourceDescription;
		this.snsId = snsId;
		this.snsName = snsName;
		this.snsProfile = snsProfile;
		this.snsConnectDate = snsConnectDate;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
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

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public String getSnsName() {
		return snsName;
	}

	public void setSnsName(String snsName) {
		this.snsName = snsName;
	}

	public String getSnsProfile() {
		return snsProfile;
	}

	public void setSnsProfile(String snsProfile) {
		this.snsProfile = snsProfile;
	}

	public Date getSnsConnectDate() {
		return snsConnectDate;
	}

	public void setSnsConnectDate(Date snsConnectDate) {
		this.snsConnectDate = snsConnectDate;
	}

	@Override
	public String toString() {
		return "SNSLogin [memberKey=" + memberKey + ", loginSourceNo=" + loginSourceNo + ", loginSourceDescription="
				+ loginSourceDescription + ", snsId=" + snsId + ", snsName=" + snsName + ", snsProfile=" + snsProfile
				+ ", snsConnectDate=" + snsConnectDate + "]";
	}
	
}
