package com.toyspace.order.coupon.model.vo;

import java.util.Date;

public class Coupon {

	private String couponId;
	private String couponTitle;
	private int availablePeriod;
	private Date expireDate;
	private int isAvailable;
	
	public Coupon() {
		// TODO Auto-generated constructor stub
	}

	public Coupon(String couponId, String couponTitle, int availablePeriod, Date expireDate, int isAvailable) {
		super();
		this.couponId = couponId;
		this.couponTitle = couponTitle;
		this.availablePeriod = availablePeriod;
		this.expireDate = expireDate;
		this.isAvailable = isAvailable;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponTitle() {
		return couponTitle;
	}

	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}

	public int getAvailablePeriod() {
		return availablePeriod;
	}

	public void setAvailablePeriod(int availablePeriod) {
		this.availablePeriod = availablePeriod;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availablePeriod;
		result = prime * result + ((couponId == null) ? 0 : couponId.hashCode());
		result = prime * result + ((couponTitle == null) ? 0 : couponTitle.hashCode());
		result = prime * result + ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + isAvailable;
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
		Coupon other = (Coupon) obj;
		if (availablePeriod != other.availablePeriod)
			return false;
		if (couponId == null) {
			if (other.couponId != null)
				return false;
		} else if (!couponId.equals(other.couponId))
			return false;
		if (couponTitle == null) {
			if (other.couponTitle != null)
				return false;
		} else if (!couponTitle.equals(other.couponTitle))
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponTitle=" + couponTitle + ", availablePeriod=" + availablePeriod
				+ ", expireDate=" + expireDate + ", isAvailable=" + isAvailable + "]";
	}

	
	
	
	
}
