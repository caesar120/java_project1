package menutable;

public class MenuDO {
	public String prodId;
	public String menuMonth;
	public String menuCategoryId;
	public String menuId;
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getMenuMonth() {
		return menuMonth;
	}
	public void setMenuMonth(String menuMonth) {
		this.menuMonth = menuMonth;
	}
	public String getMenuCategoryId() {
		return menuCategoryId;
	}
	public void setMenuCategoryId(String menuCategoryId) {
		this.menuCategoryId = menuCategoryId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "MenuDO [prodId=" + prodId + ", menuMonth=" + menuMonth + ", menuCategoryId=" + menuCategoryId
				+ ", menuId=" + menuId + "]";
	}
	
	
	
}
