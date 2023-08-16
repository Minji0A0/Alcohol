package kh.semi.alcohol.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dto.AlcoholDTO;

public class AlcoholDAO {


	public List<AlcoholDTO> selectListAlcohol(Connection conn, String borderKind) {
		List<AlcoholDTO>  result = new ArrayList<AlcoholDTO>();
		String query = "select * from TB_ALCOHOL where BORDER_KIND=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, borderKind);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AlcoholDTO vo = new AlcoholDTO(rs.getInt("PRICE_BORDER_NO"), rs.getString("BORDER_KIND"),
						rs.getString("PRODUCT_NAME"), rs.getString("RIPENING"), rs.getString("PRICE"),
						rs.getString("CAPACITY"), rs.getString("DATE_OF_PURCHASE"), rs.getString("MARKET"),
						rs.getString("NOTE"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemp.close(rs);
			JDBCTemp.close(pstmt);
		}
		return result;
	}

	public AlcoholDTO selectOneAlcohol(Connection conn, String borderKind, String productName, String price) {

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

		AlcoholDTO result = null;
		String query = "select * from TB_ALCOHOL where BORDER_KIND=? and PRODUCT_NAME=? and PRICE=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, borderKind);
			pstmt.setString(2, productName);
			pstmt.setString(3, price);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new AlcoholDTO(rs.getInt("PRICE_BORDER_NO"), rs.getString("BORDER_KIND"),
						rs.getString("PRODUCT_NAME"), rs.getString("RIPENING"), rs.getString("PRICE"),
						rs.getString("CAPACITY"), rs.getString("DATE_OF_PURCHASE"), rs.getString("MARKET"),
						rs.getString("NOTE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemp.close(rs);
			JDBCTemp.close(pstmt);
		}
		return result;
	}
}
