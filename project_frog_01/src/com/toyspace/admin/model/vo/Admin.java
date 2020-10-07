package com.toyspace.admin.model.vo;

public class Admin {
	
	private String adminId;
	private String adminPassword;
	private String nickname;
	private String adminName;
	private int adminLevel;
	private String adminLevelDescription;
	
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}


	public Admin(String adminId, String adminPassword, String nickname, String adminName, int adminLevel,
			String adminLevelDescription) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.nickname = nickname;
		this.adminName = adminName;
		this.adminLevel = adminLevel;
		this.adminLevelDescription = adminLevelDescription;
	}


	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public String getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public int getAdminLevel() {
		return adminLevel;
	}


	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}


	public String getAdminLevelDescription() {
		return adminLevelDescription;
	}


	public void setAdminLevelDescription(String adminLevelDescription) {
		this.adminLevelDescription = adminLevelDescription;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + adminLevel;
		result = prime * result + ((adminLevelDescription == null) ? 0 : adminLevelDescription.hashCode());
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((adminPassword == null) ? 0 : adminPassword.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
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
		Admin other = (Admin) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (adminLevel != other.adminLevel)
			return false;
		if (adminLevelDescription == null) {
			if (other.adminLevelDescription != null)
				return false;
		} else if (!adminLevelDescription.equals(other.adminLevelDescription))
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + ", nickname=" + nickname
				+ ", adminName=" + adminName + ", adminLevel=" + adminLevel + ", adminLevelDescription="
				+ adminLevelDescription + "]";
	}

	
}
