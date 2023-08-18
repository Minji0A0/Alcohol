package kh.semi.alcohol.member.model.dto;

import java.sql.Date;

public class AlcoholCommunityDTO {

//	--------------- -------- ------------ 
//	RE_COMMENT_NO   NOT NULL NUMBER(6)    
//	RE_CONTENT               CLOB         
//	RE_DATE_NO               DATE         
//	USER_NAME       NOT NULL VARCHAR2(50) 
//	PRICE_BORDER_NO NOT NULL NUMBER(30)   

	
	private int reCommentNo;
	private String reContent;
	private Date reDateNo;
	private String userName;
	private int priceBorderNo;
	
	public AlcoholCommunityDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AlcoholCommunityDTO [reCommentNo=" + reCommentNo + ", reContent=" + reContent + ", reDateNo=" + reDateNo
				+ ", userName=" + userName + ", priceBorderNo=" + priceBorderNo + "]";
	}

	public int getReCommentNo() {
		return reCommentNo;
	}

	public void setReCommentNo(int reCommentNo) {
		this.reCommentNo = reCommentNo;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public Date getReDateNo() {
		return reDateNo;
	}

	public void setReDateNo(Date reDateNo) {
		this.reDateNo = reDateNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPriceBorderNo() {
		return priceBorderNo;
	}

	public void setPriceBorderNo(int priceBorderNo) {
		this.priceBorderNo = priceBorderNo;
	}
	
	
	
	
}
