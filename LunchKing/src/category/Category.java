/**
 * 파일명 : Category.java
 * 작성자 : 박상철
 * 작성일 : 2017. 4. 26.
 * 파일설명 : 
 */
package category;

import java.util.*;

import product.*;

/**
 * @summary : 상품분류(Category) Bean
 * @author  : 박상철
 */
public class Category {
	private String categoryId;		// 
	private String categoryName;
	private String price;
	private String categoryImage;
	private ArrayList<Product> productList;
	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the categoryImage
	 */
	public String getCategoryImage() {
		return categoryImage;
	}
	/**
	 * @param categoryImage the categoryImage to set
	 */
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	/**
	 * @return the productList
	 */
	public ArrayList<Product> getProductList() {
		return productList;
	}
	/**
	 * @param productList the productList to set
	 */
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", price="
				+ price + ", categoryImage=" + categoryImage + "]";
	}
	
}
