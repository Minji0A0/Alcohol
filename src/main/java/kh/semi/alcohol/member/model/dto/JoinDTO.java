package kh.semi.alcohol.member.model.dto;

public class JoinDTO {
	
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
	private int usercellphone;
	private int userhomephone;
	
	public JoinDTO() {
		super();
	}

	public JoinDTO(String userId, String userName, String userPw, String userEmail, String userHome, int usercellphone,
			int userhomephone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userHome = userHome;
		this.usercellphone = usercellphone;
		this.userhomephone = userhomephone;
	}

	@Override
	public String toString() {
		return "JoinDTO [userId=" + userId + ", userName=" + userName + ", userPw=" + userPw + ", userEmail="
				+ userEmail + ", userHome=" + userHome + ", usercellphone=" + usercellphone + ", userhomephone="
				+ userhomephone + "]";
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

	public int getUsercellphone() {
		return usercellphone;
	}

	public void setUsercellphone(int usercellphone) {
		this.usercellphone = usercellphone;
	}

	public int getUserhomephone() {
		return userhomephone;
	}

	public void setUserhomephone(int userhomephone) {
		this.userhomephone = userhomephone;
	}
	
	

}
