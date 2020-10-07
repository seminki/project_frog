package com.toyspace.order.cart.model.vo;

import java.util.TreeMap;

public class Cart {
	
	private int memberKey;
	private TreeMap<Integer, Integer> productList;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int memberKey, TreeMap<Integer, Integer> productList) {
		super();
		this.memberKey = memberKey;
		this.productList = productList;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
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
		result = prime * result + memberKey;
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
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
		Cart other = (Cart) obj;
		if (memberKey != other.memberKey)
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [memberKey=" + memberKey + ", productList=" + productList + "]";
	}

	
	
}
