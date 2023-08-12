package kh.semi.alcohol.member.model.dto;

public class MemberDTO {

//	-------------- -------- ------------- 
//	USER_ID        NOT NULL VARCHAR2(20)  
//	USER_NAME      NOT NULL VARCHAR2(50)  
//	USER_PW        NOT NULL VARCHAR2(20)  
//	USER_EMAIL              VARCHAR2(255) 
//	USER_HOME               VARCHAR2(255) 
//	USER_CELLPHONE          NUMBER        
//	USER_HOMEPHONE          NUMBER     
	
	private String userId;
	private String userName;
	private String userPw;
	private String userEmail;
	private String userHome;
	private int userCellphone;
	private int userHomephone;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String userId, String userName, String userPw, String userEmail, String userHome,
			int userCellphone, int userHomephone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userHome = userHome;
		this.userCellphone = userCellphone;
		this.userHomephone = userHomephone;
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userName=" + userName + ", userPw=" + userPw + ", userEmail="
				+ userEmail + ", userHome=" + userHome + ", userCellphone=" + userCellphone + ", userHomephone="
				+ userHomephone + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserHome() {
		return userHome;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	public int getUserCellphone() {
		return userCellphone;
	}

	public void setUserCellphone(int userCellphone) {
		this.userCellphone = userCellphone;
	}

	public int getUserHomephone() {
		return userHomephone;
	}

	public void setUserHomephone(int userHomephone) {
		this.userHomephone = userHomephone;
	}
	
	
}