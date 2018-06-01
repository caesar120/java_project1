/**
 * 파일명 : Board.java
 * 작성자 : 이우송
 * 파일설명 :
 */
package fileUpload;

/**
 * @author User
 *
 */
public class Board2 {
	String no;				 // 번호
	String title;     		 // 제목
	String contents;  		 // 내용
	String wdate;     		 // 작성일자
	String userid;    		 // 작성자
	String originalfileName; // 원래 파일명
	String uploadedfileName; // 업로드된 파일명
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}
	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	/**
	 * @return the wdate
	 */
	public String getWdate() {
		return wdate;
	}
	/**
	 * @param wdate the wdate to set
	 */
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the originalfileName
	 */
	public String getOriginalfileName() {
		return originalfileName;
	}
	/**
	 * @param originalfileName the originalfileName to set
	 */
	public void setOriginalfileName(String originalfileName) {
		this.originalfileName = originalfileName;
	}
	/**
	 * @return the uploadedfileName
	 */
	public String getUploadedfileName() {
		return uploadedfileName;
	}
	/**
	 * @param uploadedfileName the uploadedfileName to set
	 */
	public void setUploadedfileName(String uploadedfileName) {
		this.uploadedfileName = uploadedfileName;
	}
	
}
