package com.toyspace.product.comment.model.vo;

import java.util.Date;

public class Comment {
	
	private int productCommentNo;
	private int productId;
	private int memberKey;
	private int commentRefNo;
	private boolean isSecret;
	private String commentContent;
	private Date commentDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int productCommentNo, int productId, int memberKey, int commentRefNo, boolean isSecret,
			String commentContent, Date commentDate) {
		super();
		this.productCommentNo = productCommentNo;
		this.productId = productId;
		this.memberKey = memberKey;
		this.commentRefNo = commentRefNo;
		this.isSecret = isSecret;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((commentDate == null) ? 0 : commentDate.hashCode());
		result = prime * result + commentRefNo;
		result = prime * result + (isSecret ? 1231 : 1237);
		result = prime * result + memberKey;
		result = prime * result + productCommentNo;
		result = prime * result + productId;
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
		if (isSecret != other.isSecret)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (productCommentNo != other.productCommentNo)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [productCommentNo=" + productCommentNo + ", productId=" + productId + ", memberKey=" + memberKey
				+ ", commentRefNo=" + commentRefNo + ", isSecret=" + isSecret + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + "]";
	}
	
	
}
