package kh.semi.alcohol.member.model.dto;

public class AlcoholDTO {

//	---------------- -------- ------------- 
//	PRICE_BORDER_NO  NOT NULL NUMBER(30)    
//	BORDER_KIND      NOT NULL VARCHAR2(100) 
//	PRODUCT_NAME     NOT NULL VARCHAR2(255) 
//	RIPENING                  VARCHAR2(100) 
//	PRICE            NOT NULL VARCHAR2(100) 
//	CAPACITY                  VARCHAR2(100) 
//	DATE_OF_PURCHASE          VARCHAR2(100) 
//	MARKET           NOT NULL VARCHAR2(100) 
//	NOTE                      VARCHAR2(100) 

	private int priceBorderNo;
	private String borderKind;
	private String productName;
	private String ripening;
	private String price;
	private String capacity;
	private String dateOfPurcharse;
	private String market;
	private String note;
	
	public AlcoholDTO() {
		super();
	}

	public AlcoholDTO(int priceBorderNo, String borderKind, String productName, String ripening, String price,
			String capacity, String dateOfPurcharse, String market, String note) {
		super();
		this.priceBorderNo = priceBorderNo;
		this.borderKind = borderKind;
		this.productName = productName;
		this.ripening = ripening;
		this.price = price;
		this.capacity = capacity;
		this.dateOfPurcharse = dateOfPurcharse;
		this.market = market;
		this.note = note;
	}

	@Override
	public String toString() {
		return "AlcoholDTO [priceBorderNo=" + priceBorderNo + ", borderKind=" + borderKind + ", productName="
				+ productName + ", ripening=" + ripening + ", price=" + price + ", capacity=" + capacity
				+ ", dateOfPurcharse=" + dateOfPurcharse + ", market=" + market + ", note=" + note + "]";
	}

	public int getPriceBorderNo() {
		return priceBorderNo;
	}

	public void setPriceBorderNo(int priceBorderNo) {
		this.priceBorderNo = priceBorderNo;
	}

	public String getBorderKind() {
		return borderKind;
	}

	public void setBorderKind(String borderKind) {
		this.borderKind = borderKind;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRipening() {
		return ripening;
	}

	public void setRipening(String ripening) {
		this.ripening = ripening;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getDateOfPurcharse() {
		return dateOfPurcharse;
	}

	public void setDateOfPurcharse(String dateOfPurcharse) {
		this.dateOfPurcharse = dateOfPurcharse;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	
}
