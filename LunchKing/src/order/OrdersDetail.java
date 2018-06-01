/**
 * 파일명 : OrdersDetailDO.java
 * 작성일 : 2017. 4. 28.
 * 파일설명 : 	
 */
package order;

/**
 * @author User
 *
 */
public class OrdersDetail {
	String detailId;
	String orderTerm;
	String shipStartDate;
	String shipEndDate;
	String shipState;
	String orderCount;
	String categoryId;
	String pauseStartDate;
	String pauseCancelDate;
	String pauseRequestDate;
	String orderId;
	/**
	 * @return the detailId
	 */
	public String getDetailId() {
		return detailId;
	}
	/**
	 * @param detailId the detailId to set
	 */
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	/**
	 * @return the orderTerm
	 */
	public String getOrderTerm() {
		return orderTerm;
	}
	/**
	 * @param orderTerm the orderTerm to set
	 */
	public void setOrderTerm(String orderTerm) {
		this.orderTerm = orderTerm;
	}
	/**
	 * @return the shipStartDate
	 */
	public String getShipStartDate() {
		return shipStartDate;
	}
	/**
	 * @param shipStartDate the shipStartDate to set
	 */
	public void setShipStartDate(String shipStartDate) {
		this.shipStartDate = shipStartDate;
	}
	/**
	 * @return the shipEndDate
	 */
	public String getShipEndDate() {
		return shipEndDate;
	}
	/**
	 * @param shipEndDate the shipEndDate to set
	 */
	public void setShipEndDate(String shipEndDate) {
		this.shipEndDate = shipEndDate;
	}
	/**
	 * @return the shipState
	 */
	public String getShipState() {
		return shipState;
	}
	/**
	 * @param shipState the shipState to set
	 */
	public void setShipState(String shipState) {
		this.shipState = shipState;
	}
	/**
	 * @return the orderCount
	 */
	public String getOrderCount() {
		return orderCount;
	}
	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
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
	/**
	 * @return the pauseStartDate
	 */
	public String getPauseStartDate() {
		return pauseStartDate;
	}
	/**
	 * @param pauseStartDate the pauseStartDate to set
	 */
	public void setPauseStartDate(String pauseStartDate) {
		this.pauseStartDate = pauseStartDate;
	}
	/**
	 * @return the pauseCancelDate
	 */
	public String getPauseCancelDate() {
		return pauseCancelDate;
	}
	/**
	 * @param pauseCancelDate the pauseCancelDate to set
	 */
	public void setPauseCancelDate(String pauseCancelDate) {
		this.pauseCancelDate = pauseCancelDate;
	}
	/**
	 * @return the pauseRequestDate
	 */
	public String getPauseRequestDate() {
		return pauseRequestDate;
	}
	/**
	 * @param pauseRequestDate the pauseRequestDate to set
	 */
	public void setPauseRequestDate(String pauseRequestDate) {
		this.pauseRequestDate = pauseRequestDate;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrdersDetail [detailId=" + detailId + ", orderTerm=" + orderTerm + ", shipStartDate=" + shipStartDate
				+ ", shipEndDate=" + shipEndDate + ", shipState=" + shipState + ", orderCount=" + orderCount
				+ ", categoryId=" + categoryId + ", pauseStartDate=" + pauseStartDate + ", pauseCancelDate="
				+ pauseCancelDate + ", pauseRequestDate=" + pauseRequestDate + ", orderId=" + orderId + "]";
	}
	
}
