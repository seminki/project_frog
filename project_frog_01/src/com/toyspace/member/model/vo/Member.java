package com.toyspace.member.model.vo;

import java.util.ArrayList;
import java.util.Date;

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
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberKey, String userId, String userEmail, String password, String userGender, String userName,
			String userNickname, int userAge, String userBirthday, String userAddress, String userPhone,
			Date userSignUpDate, String userProfilePicPath, int userMileage, String recoveryPassword, int memberLevelNo,
			String memberLevelDescription, Date modifiedDate, ArrayList<Coupon> ownedCoupons) {
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
		this.memberLevelDescription = memberLevelDescription;
		this.modifiedDate = modifiedDate;
		this.ownedCoupons = ownedCoupons;
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
	}

	public String getMemberLevelDescription() {
		return memberLevelDescription;
	}

	public void setMemberLevelDescription(String memberLevelDescription) {
		this.memberLevelDescription = memberLevelDescription;
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

	@Override
	public String toString() {
		return "Member [memberKey=" + memberKey + ", userId=" + userId + ", userEmail=" + userEmail + ", password="
				+ password + ", userGender=" + userGender + ", userName=" + userName + ", userNickname=" + userNickname
				+ ", userAge=" + userAge + ", userBirthday=" + userBirthday + ", userAddress=" + userAddress
				+ ", userPhone=" + userPhone + ", userSignUpDate=" + userSignUpDate + ", userProfilePicPath="
				+ userProfilePicPath + ", userMileage=" + userMileage + ", recoveryPassword=" + recoveryPassword
				+ ", memberLevelNo=" + memberLevelNo + ", memberLevelDescription=" + memberLevelDescription
				+ ", modifiedDate=" + modifiedDate + ", ownedCoupons=" + ownedCoupons + "]";
	}

	
}