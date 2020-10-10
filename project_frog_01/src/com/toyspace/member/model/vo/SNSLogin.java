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
	private String accessToken;
	private String refreshToken;
	private Date refreshTokenValidDate;
	
	
	public SNSLogin() {
		// TODO Auto-generated constructor stub
	}


	public SNSLogin(int memberKey, int loginSourceNo, String loginSourceDescription, String snsId, String snsName,
			String snsProfile, Date snsConnectDate, String accessToken, String refreshToken,
			Date refreshTokenValidDate) {
		super();
		this.memberKey = memberKey;
		this.loginSourceNo = loginSourceNo;
		this.loginSourceDescription = loginSourceDescription;
		this.snsId = snsId;
		this.snsName = snsName;
		this.snsProfile = snsProfile;
		this.snsConnectDate = snsConnectDate;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.refreshTokenValidDate = refreshTokenValidDate;
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


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getRefreshToken() {
		return refreshToken;
	}


	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}


	public Date getRefreshTokenValidDate() {
		return refreshTokenValidDate;
	}


	public void setRefreshTokenValidDate(Date refreshTokenValidDate) {
		this.refreshTokenValidDate = refreshTokenValidDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
		result = prime * result + ((loginSourceDescription == null) ? 0 : loginSourceDescription.hashCode());
		result = prime * result + loginSourceNo;
		result = prime * result + memberKey;
		result = prime * result + ((refreshToken == null) ? 0 : refreshToken.hashCode());
		result = prime * result + ((refreshTokenValidDate == null) ? 0 : refreshTokenValidDate.hashCode());
		result = prime * result + ((snsConnectDate == null) ? 0 : snsConnectDate.hashCode());
		result = prime * result + ((snsId == null) ? 0 : snsId.hashCode());
		result = prime * result + ((snsName == null) ? 0 : snsName.hashCode());
		result = prime * result + ((snsProfile == null) ? 0 : snsProfile.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SNSLogin other = (SNSLogin) obj;
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		if (loginSourceDescription == null) {
			if (other.loginSourceDescription != null)
				return false;
		} else if (!loginSourceDescription.equals(other.loginSourceDescription))
			return false;
		if (loginSourceNo != other.loginSourceNo)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (refreshToken == null) {
			if (other.refreshToken != null)
				return false;
		} else if (!refreshToken.equals(other.refreshToken))
			return false;
		if (refreshTokenValidDate == null) {
			if (other.refreshTokenValidDate != null)
				return false;
		} else if (!refreshTokenValidDate.equals(other.refreshTokenValidDate))
			return false;
		if (snsConnectDate == null) {
			if (other.snsConnectDate != null)
				return false;
		} else if (!snsConnectDate.equals(other.snsConnectDate))
			return false;
		if (snsId == null) {
			if (other.snsId != null)
				return false;
		} else if (!snsId.equals(other.snsId))
			return false;
		if (snsName == null) {
			if (other.snsName != null)
				return false;
		} else if (!snsName.equals(other.snsName))
			return false;
		if (snsProfile == null) {
			if (other.snsProfile != null)
				return false;
		} else if (!snsProfile.equals(other.snsProfile))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SNSLogin [memberKey=" + memberKey + ", loginSourceNo=" + loginSourceNo + ", loginSourceDescription="
				+ loginSourceDescription + ", snsId=" + snsId + ", snsName=" + snsName + ", snsProfile=" + snsProfile
				+ ", snsConnectDate=" + snsConnectDate + ", accessToken=" + accessToken + ", refreshToken="
				+ refreshToken + ", refreshTokenValidDate=" + refreshTokenValidDate + "]";
	}
	
}
