package com.toyspace.product.model.vo;

import java.util.List;

public class Product implements Comparable<Product>{
	
	private int productId;
	private int categoryNo;
	private String categoryName;
	private String productName;
	private double productPrice;
	private int productStock;
	private String productDescription;
	private String manufacturer;
	private String manufacturedCountry;
	private int recommendedAge;
	private String caution;
	private List<String> productImageFilePaths;
	private int likes;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.productId-o.productId;
	}


	public Product(int productId, int categoryNo, String categoryName, String productName, double productPrice,
			int productStock, String productDescription, String manufacturer, String manufacturedCountry,
			int recommendedAge, String caution, List<String> productImageFilePaths, int likes) {
		super();
		this.productId = productId;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		switch(categoryNo) {
		case 1: this.categoryName = "디즈니"; break; 
		case 2: this.categoryName = "스타워즈"; break; 
		case 3: this.categoryName = "왕좌의 게임"; break; 
		case 4: this.categoryName = "포켓몬스터"; break; 
		case 5: this.categoryName = "마블"; break; 
		}
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productDescription = productDescription;
		this.manufacturer = manufacturer;
		this.manufacturedCountry = manufacturedCountry;
		this.recommendedAge = recommendedAge;
		this.caution = caution;
		this.productImageFilePaths = productImageFilePaths;
		this.likes = likes;
		
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
		switch(categoryNo) {
		case 1: this.categoryName = "디즈니"; break; 
		case 2: this.categoryName = "스타워즈"; break; 
		case 3: this.categoryName = "왕좌의 게임"; break; 
		case 4: this.categoryName = "포켓몬스터"; break; 
		case 5: this.categoryName = "마블"; break; 
		}
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductStock() {
		return productStock;
	}


	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getManufacturedCountry() {
		return manufacturedCountry;
	}


	public void setManufacturedCountry(String manufacturedCountry) {
		this.manufacturedCountry = manufacturedCountry;
	}


	public int getRecommendedAge() {
		return recommendedAge;
	}


	public void setRecommendedAge(int recommendedAge) {
		this.recommendedAge = recommendedAge;
	}


	public String getCaution() {
		return caution;
	}


	public void setCaution(String caution) {
		this.caution = caution;
	}


	public List<String> getProductImageFilePaths() {
		return productImageFilePaths;
	}


	public void setProductImageFilePaths(List<String> productImageFilePaths) {
		this.productImageFilePaths = productImageFilePaths;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + categoryNo;
		result = prime * result + ((caution == null) ? 0 : caution.hashCode());
		result = prime * result + likes;
		result = prime * result + ((manufacturedCountry == null) ? 0 : manufacturedCountry.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productImageFilePaths == null) ? 0 : productImageFilePaths.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productStock;
		result = prime * result + recommendedAge;
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
		Product other = (Product) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (categoryNo != other.categoryNo)
			return false;
		if (caution == null) {
			if (other.caution != null)
				return false;
		} else if (!caution.equals(other.caution))
			return false;
		if (likes != other.likes)
			return false;
		if (manufacturedCountry == null) {
			if (other.manufacturedCountry != null)
				return false;
		} else if (!manufacturedCountry.equals(other.manufacturedCountry))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId != other.productId)
			return false;
		if (productImageFilePaths == null) {
			if (other.productImageFilePaths != null)
				return false;
		} else if (!productImageFilePaths.equals(other.productImageFilePaths))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (productStock != other.productStock)
			return false;
		if (recommendedAge != other.recommendedAge)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productStock=" + productStock
				+ ", productDescription=" + productDescription + ", manufacturer=" + manufacturer
				+ ", manufacturedCountry=" + manufacturedCountry + ", recommendedAge=" + recommendedAge + ", caution="
				+ caution + ", productImageFilePaths=" + productImageFilePaths + ", likes=" + likes + "]";
	}


	
}