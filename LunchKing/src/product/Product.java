/**
 * 파일명 : Product.java
 * 작성자 : 박상철
 * 작성일 : 2017. 5. 1.
 * 파일설명 : 
 */
package product;

/**
 * @summary : 상품(Product) Bean
 * @author  : 박상철
 */
public class Product {

	private String prodId;
	private String prodName;
	private String description;
	private String detail;
	private String prodImage;
	private String categoryId;
	/**
	 * @return the prodId
	 */
	public String getProdId() {
		return prodId;
	}
	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * @param prodName the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * @return the prodImage
	 */
	public String getProdImage() {
		return prodImage;
	}
	/**
	 * @param prodImage the prodImage to set
	 */
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", description=" + description + ", detail="
				+ detail + ", prodImage=" + prodImage + ", categoryId=" + categoryId + "]";
	}
	
}
