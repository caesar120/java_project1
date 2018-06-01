package board;

public class BoardBean {
	String boardId;			//글번호
	String title;			//제목
	String boardType;		//게시판 분류 번호
	String viewCount;		//조회수
	String content;			//내용
	String creationTime;	//작성일자
	String userId;			//사용자 아이디
	String boardImage;
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardImage() {
		return boardImage;
	}
	public void setBoardImage(String boardImage) {
		this.boardImage = boardImage;
	}
	@Override
	public String toString() {
		return "BoardBean [boardId=" + boardId + ", title=" + title + ", boardType=" + boardType + ", viewCount="
				+ viewCount + ", content=" + content + ", creationTime=" + creationTime + ", userId=" + userId
				+ ", boardImage=" + boardImage + "]";
	}
}