/**
 * 파일명 : Login.java
 * 작성자 : 신동섭
 * 파일설명 : Login DO = LoginBean
 */
package login;

public class LoginBean {

	//필드명 '_'(언더바) 제거후 대문자로 변경완료, 
	//passwd의 'w'는 소문자 사용함
	
	public String userId;
	public String passwd;
	public String userName;
	public String email;
	public String phone;
	public String addr;
	public String gatepw;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * @return the gatepw
	 */
	public String getGatepw() {
		return gatepw;
	}
	/**
	 * @param gatepw the gatepw to set
	 */
	public void setGatepw(String gatepw) {
		this.gatepw = gatepw;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginBean [userId=" + userId + ", passwd=" + passwd + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", addr=" + addr + ", gatepw=" + gatepw + "]";
	}
	
}
