package order;

public class Orders {
	String orderId;
	String userId;
	String orderDate;
	String orderAddr;
	String totalPrice;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "OrdersDO [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", orderAddr="
				+ orderAddr + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
