package com.toyspace.product.model.vo;

public class Tags implements Comparable<Tags>{

	private int tagNo;
	private String tagName;
	
	public Tags() {
		// TODO Auto-generated constructor stub
	}

	public Tags(int tagNo, String tagName) {
		super();
		this.tagNo = tagNo;
		this.tagName = tagName;
	}
	
	@Override
	public int compareTo(Tags t) {
		// TODO Auto-generated method stub
		return this.tagNo-t.tagNo;
	}
	
	public int getTagNo() {
		return tagNo;
	}

	public void setTagNo(int tagNo) {
		this.tagNo = tagNo;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + tagNo;
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
		Tags other = (Tags) obj;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		if (tagNo != other.tagNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tags [tagNo=" + tagNo + ", tagName=" + tagName + "]";
	}

	
	
	
}
