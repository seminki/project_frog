package com.toyspace.order.history.model.vo;

import java.util.Date;
import java.util.TreeMap;

public class OrderHistory {

	private int orderNo;
	private int importUid;
	private int memberKey;
	private Date orderedDate;
	private String paymentMethod;
	private int orderStatusNo;
	private String statusDetail;
	private String applyNum;
	private String merchantUid;
	private String buyerTel;
	private String receiverName;
	private String receiverTel;
	private String receiverPostcode;
	private String receiverAddr;
	private String receiverComment;
	private TreeMap<Integer, Integer> productList;

	public OrderHistory() {
		// TODO Auto-generated constructor stub
	}

	public OrderHistory(int orderNo, int importUid, int memberKey, Date orderedDate, String paymentMethod,
			int orderStatusNo, String statusDetail, String applyNum, String merchantUid, String buyerTel,
			String receiverName, String receiverTel, String receiverPostcode, String receiverAddr,
			String receiverComment, TreeMap<Integer, Integer> productList) {
		super();
		this.orderNo = orderNo;
		this.importUid = importUid;
		this.memberKey = memberKey;
		this.orderedDate = orderedDate;
		this.paymentMethod = paymentMethod;
		this.orderStatusNo = orderStatusNo;
		this.statusDetail = statusDetail;
		this.applyNum = applyNum;
		this.merchantUid = merchantUid;
		this.buyerTel = buyerTel;
		this.receiverName = receiverName;
		this.receiverTel = receiverTel;
		this.receiverPostcode = receiverPostcode;
		this.receiverAddr = receiverAddr;
		this.receiverComment = receiverComment;
		this.productList = productList;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getImportUid() {
		return importUid;
	}

	public void setImportUid(int importUid) {
		this.importUid = importUid;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getOrderStatusNo() {
		return orderStatusNo;
	}

	public void setOrderStatusNo(int orderStatusNo) {
		this.orderStatusNo = orderStatusNo;
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	public String getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}

	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverTel() {
		return receiverTel;
	}

	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}

	public String getReceiverPostcode() {
		return receiverPostcode;
	}

	public void setReceiverPostcode(String receiverPostcode) {
		this.receiverPostcode = receiverPostcode;
	}

	public String getReceiverAddr() {
		return receiverAddr;
	}

	public void setReceiverAddr(String receiverAddr) {
		this.receiverAddr = receiverAddr;
	}

	public String getReceiverComment() {
		return receiverComment;
	}

	public void setReceiverComment(String receiverComment) {
		this.receiverComment = receiverComment;
	}

	public TreeMap<Integer, Integer> getProductList() {
		return productList;
	}

	public void setProductList(TreeMap<Integer, Integer> productList) {
		this.productList = productList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyNum == null) ? 0 : applyNum.hashCode());
		result = prime * result + ((buyerTel == null) ? 0 : buyerTel.hashCode());
		result = prime * result + importUid;
		result = prime * result + memberKey;
		result = prime * result + ((merchantUid == null) ? 0 : merchantUid.hashCode());
		result = prime * result + orderNo;
		result = prime * result + orderStatusNo;
		result = prime * result + ((orderedDate == null) ? 0 : orderedDate.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		result = prime * result + ((receiverAddr == null) ? 0 : receiverAddr.hashCode());
		result = prime * result + ((receiverComment == null) ? 0 : receiverComment.hashCode());
		result = prime * result + ((receiverName == null) ? 0 : receiverName.hashCode());
		result = prime * result + ((receiverPostcode == null) ? 0 : receiverPostcode.hashCode());
		result = prime * result + ((receiverTel == null) ? 0 : receiverTel.hashCode());
		result = prime * result + ((statusDetail == null) ? 0 : statusDetail.hashCode());
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
		OrderHistory other = (OrderHistory) obj;
		if (applyNum == null) {
			if (other.applyNum != null)
				return false;
		} else if (!applyNum.equals(other.applyNum))
			return false;
		if (buyerTel == null) {
			if (other.buyerTel != null)
				return false;
		} else if (!buyerTel.equals(other.buyerTel))
			return false;
		if (importUid != other.importUid)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (merchantUid == null) {
			if (other.merchantUid != null)
				return false;
		} else if (!merchantUid.equals(other.merchantUid))
			return false;
		if (orderNo != other.orderNo)
			return false;
		if (orderStatusNo != other.orderStatusNo)
			return false;
		if (orderedDate == null) {
			if (other.orderedDate != null)
				return false;
		} else if (!orderedDate.equals(other.orderedDate))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (receiverAddr == null) {
			if (other.receiverAddr != null)
				return false;
		} else if (!receiverAddr.equals(other.receiverAddr))
			return false;
		if (receiverComment == null) {
			if (other.receiverComment != null)
				return false;
		} else if (!receiverComment.equals(other.receiverComment))
			return false;
		if (receiverName == null) {
			if (other.receiverName != null)
				return false;
		} else if (!receiverName.equals(other.receiverName))
			return false;
		if (receiverPostcode == null) {
			if (other.receiverPostcode != null)
				return false;
		} else if (!receiverPostcode.equals(other.receiverPostcode))
			return false;
		if (receiverTel == null) {
			if (other.receiverTel != null)
				return false;
		} else if (!receiverTel.equals(other.receiverTel))
			return false;
		if (statusDetail == null) {
			if (other.statusDetail != null)
				return false;
		} else if (!statusDetail.equals(other.statusDetail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderNo=" + orderNo + ", importUid=" + importUid + ", memberKey=" + memberKey
				+ ", orderedDate=" + orderedDate + ", paymentMethod=" + paymentMethod + ", orderStatusNo="
				+ orderStatusNo + ", statusDetail=" + statusDetail + ", applyNum=" + applyNum + ", merchantUid="
				+ merchantUid + ", buyerTel=" + buyerTel + ", receiverName=" + receiverName + ", receiverTel="
				+ receiverTel + ", receiverPostcode=" + receiverPostcode + ", receiverAddr=" + receiverAddr
				+ ", receiverComment=" + receiverComment + ", productList=" + productList + "]";
	}

	
}