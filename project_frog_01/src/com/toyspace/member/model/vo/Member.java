package com.toyspace.member.model.vo;

import java.util.ArrayList;
import java.sql.Date;

import com.toyspace.order.coupon.model.vo.Coupon;

public class Member {
	
	private int memberKey;
	private String userId;
	private String userEmail;
	private String password;
	private String userGender;
	private String userName;
	private String userNickname;
	private int userAge;
	private String userBirthday;
	private String userAddress;
	private String userPhone;
	private Date userSignUpDate;
	private String userProfilePicPath;
	private int userMileage;
	private String recoveryPassword;
	private int memberLevelNo;
	private String memberLevelDescription;
	private Date modifiedDate;
	private ArrayList<Coupon> ownedCoupons;
	private String userProfilePicUrl;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberKey, String userId, String userEmail, String password, String userGender, String userName,
			String userNickname, int userAge, String userBirthday, String userAddress, String userPhone,
			Date userSignUpDate, String userProfilePicPath, int userMileage, String recoveryPassword, int memberLevelNo,
			Date modifiedDate, ArrayList<Coupon> ownedCoupons,
			String userProfilePicUrl) {
		super();
		this.memberKey = memberKey;
		this.userId = userId;
		this.userEmail = userEmail;
		this.password = password;
		this.userGender = userGender;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userAge = userAge;
		this.userBirthday = userBirthday;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userSignUpDate = userSignUpDate;
		this.userProfilePicPath = userProfilePicPath;
		this.userMileage = userMileage;
		this.recoveryPassword = recoveryPassword;
		this.memberLevelNo = memberLevelNo;
		this.modifiedDate = modifiedDate;
		this.ownedCoupons = ownedCoupons;
		this.userProfilePicUrl = userProfilePicUrl;
		
		switch(memberLevelNo) {
		case 1: this.memberLevelDescription = "회원"; break;
		case 2: this.memberLevelDescription = "단골"; break;
		case 3: this.memberLevelDescription = "VIP"; break;
		case 0: this.memberLevelDescription = "관리자"; break;
		default : this.memberLevelDescription = null;
		}
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getUserSignUpDate() {
		return userSignUpDate;
	}

	public void setUserSignUpDate(Date userSignUpDate) {
		this.userSignUpDate = userSignUpDate;
	}

	public String getUserProfilePicPath() {
		return userProfilePicPath;
	}

	public void setUserProfilePicPath(String userProfilePicPath) {
		this.userProfilePicPath = userProfilePicPath;
	}

	public int getUserMileage() {
		return userMileage;
	}

	public void setUserMileage(int userMileage) {
		this.userMileage = userMileage;
	}

	public String getRecoveryPassword() {
		return recoveryPassword;
	}

	public void setRecoveryPassword(String recoveryPassword) {
		this.recoveryPassword = recoveryPassword;
	}

	public int getMemberLevelNo() {
		return memberLevelNo;
	}

	public void setMemberLevelNo(int memberLevelNo) {
		this.memberLevelNo = memberLevelNo;
		switch(memberLevelNo) {
		case 1: this.memberLevelDescription = "회원"; break;
		case 2: this.memberLevelDescription = "단골"; break;
		case 3: this.memberLevelDescription = "VIP"; break;
		case 0: this.memberLevelDescription = "관리자"; break;
		default : this.memberLevelDescription = null ;
		}
	}

	public String getMemberLevelDescription() {
		return memberLevelDescription;
	}



	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public ArrayList<Coupon> getOwnedCoupons() {
		return ownedCoupons;
	}

	public void setOwnedCoupons(ArrayList<Coupon> ownedCoupons) {
		this.ownedCoupons = ownedCoupons;
	}

	public String getUserProfilePicUrl() {
		return userProfilePicUrl;
	}

	public void setUserProfilePicUrl(String userProfilePicUrl) {
		this.userProfilePicUrl = userProfilePicUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberKey;
		result = prime * result + ((memberLevelDescription == null) ? 0 : memberLevelDescription.hashCode());
		result = prime * result + memberLevelNo;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((ownedCoupons == null) ? 0 : ownedCoupons.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((recoveryPassword == null) ? 0 : recoveryPassword.hashCode());
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + userAge;
		result = prime * result + ((userBirthday == null) ? 0 : userBirthday.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userGender == null) ? 0 : userGender.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + userMileage;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userNickname == null) ? 0 : userNickname.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
		result = prime * result + ((userProfilePicPath == null) ? 0 : userProfilePicPath.hashCode());
		result = prime * result + ((userProfilePicUrl == null) ? 0 : userProfilePicUrl.hashCode());
		result = prime * result + ((userSignUpDate == null) ? 0 : userSignUpDate.hashCode());
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
		Member other = (Member) obj;
		if (memberKey != other.memberKey)
			return false;
		if (memberLevelDescription == null) {
			if (other.memberLevelDescription != null)
				return false;
		} else if (!memberLevelDescription.equals(other.memberLevelDescription))
			return false;
		if (memberLevelNo != other.memberLevelNo)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (ownedCoupons == null) {
			if (other.ownedCoupons != null)
				return false;
		} else if (!ownedCoupons.equals(other.ownedCoupons))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (recoveryPassword == null) {
			if (other.recoveryPassword != null)
				return false;
		} else if (!recoveryPassword.equals(other.recoveryPassword))
			return false;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userAge != other.userAge)
			return false;
		if (userBirthday == null) {
			if (other.userBirthday != null)
				return false;
		} else if (!userBirthday.equals(other.userBirthday))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userGender == null) {
			if (other.userGender != null)
				return false;
		} else if (!userGender.equals(other.userGender))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userMileage != other.userMileage)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userNickname == null) {
			if (other.userNickname != null)
				return false;
		} else if (!userNickname.equals(other.userNickname))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		if (userProfilePicPath == null) {
			if (other.userProfilePicPath != null)
				return false;
		} else if (!userProfilePicPath.equals(other.userProfilePicPath))
			return false;
		if (userProfilePicUrl == null) {
			if (other.userProfilePicUrl != null)
				return false;
		} else if (!userProfilePicUrl.equals(other.userProfilePicUrl))
			return false;
		if (userSignUpDate == null) {
			if (other.userSignUpDate != null)
				return false;
		} else if (!userSignUpDate.equals(other.userSignUpDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [memberKey=" + memberKey + ", userId=" + userId + ", userEmail=" + userEmail + ", password="
				+ password + ", userGender=" + userGender + ", userName=" + userName + ", userNickname=" + userNickname
				+ ", userAge=" + userAge + ", userBirthday=" + userBirthday + ", userAddress=" + userAddress
				+ ", userPhone=" + userPhone + ", userSignUpDate=" + userSignUpDate + ", userProfilePicPath="
				+ userProfilePicPath + ", userMileage=" + userMileage + ", recoveryPassword=" + recoveryPassword
				+ ", memberLevelNo=" + memberLevelNo + ", memberLevelDescription=" + memberLevelDescription
				+ ", modifiedDate=" + modifiedDate + ", ownedCoupons=" + ownedCoupons + ", userProfilePicUrl="
				+ userProfilePicUrl + "]";
	}

}