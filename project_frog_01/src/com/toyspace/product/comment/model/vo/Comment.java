package com.toyspace.product.comment.model.vo;

import java.util.Date;

public class Comment implements Comparable<Comment>{
	
	private int productCommentNo;
	private int productId;
	private int memberKey;
	private int commentRefNo;
	private boolean isSecret;
	private boolean isDeleted;
	private String commentContent;
	private Date commentDate;
	private String userId;
	private String userNickname;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}


	public Comment(int productCommentNo, int productId, int memberKey, int commentRefNo, boolean isSecret,
			boolean isDeleted, String commentContent, Date commentDate) {
		super();
		this.productCommentNo = productCommentNo;
		this.productId = productId;
		this.memberKey = memberKey;
		this.commentRefNo = commentRefNo;
		this.isSecret = isSecret;
		this.isDeleted = isDeleted;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	
	
	
	public Comment(int productCommentNo, int productId, int memberKey, int commentRefNo, boolean isSecret,
			boolean isDeleted, String commentContent, Date commentDate, String userId, String userNickname) {
		super();
		this.productCommentNo = productCommentNo;
		this.productId = productId;
		this.memberKey = memberKey;
		this.commentRefNo = commentRefNo;
		this.isSecret = isSecret;
		this.isDeleted = isDeleted;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.userId = userId;
		this.userNickname = userNickname;
	}


	@Override
	public int compareTo(Comment o) {
		// TODO Auto-generated method stub
		return this.productCommentNo-o.productCommentNo;
	}


	public int getProductCommentNo() {
		return productCommentNo;
	}

	public void setProductCommentNo(int productCommentNo) {
		this.productCommentNo = productCommentNo;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public int getCommentRefNo() {
		return commentRefNo;
	}

	public void setCommentRefNo(int commentRefNo) {
		this.commentRefNo = commentRefNo;
	}

	public boolean isSecret() {
		return isSecret;
	}

	public void setSecret(boolean isSecret) {
		this.isSecret = isSecret;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((commentDate == null) ? 0 : commentDate.hashCode());
		result = prime * result + commentRefNo;
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isSecret ? 1231 : 1237);
		result = prime * result + memberKey;
		result = prime * result + productCommentNo;
		result = prime * result + productId;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userNickname == null) ? 0 : userNickname.hashCode());
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
		Comment other = (Comment) obj;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentDate == null) {
			if (other.commentDate != null)
				return false;
		} else if (!commentDate.equals(other.commentDate))
			return false;
		if (commentRefNo != other.commentRefNo)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isSecret != other.isSecret)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (productCommentNo != other.productCommentNo)
			return false;
		if (productId != other.productId)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userNickname == null) {
			if (other.userNickname != null)
				return false;
		} else if (!userNickname.equals(other.userNickname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Comment [productCommentNo=" + productCommentNo + ", productId=" + productId + ", memberKey=" + memberKey
				+ ", commentRefNo=" + commentRefNo + ", isSecret=" + isSecret + ", isDeleted=" + isDeleted
				+ ", commentContent=" + commentContent + ", commentDate=" + commentDate + ", userId=" + userId
				+ ", userNickname=" + userNickname + "]";
	}


	


	
}
