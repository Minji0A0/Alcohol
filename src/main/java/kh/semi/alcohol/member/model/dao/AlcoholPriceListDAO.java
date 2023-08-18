package kh.semi.alcohol.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dto.AlcoholDTO;
import kh.semi.alcohol.member.model.dto.AlcoholPriceListDTO;

import static kh.semi.alcohol.common.JDBCTemp.*;

public class AlcoholPriceListDAO {

	public AlcoholPriceListDTO selectOneAlcohol(Connection conn, String priceBorderNo) {
		System.out.println("DAO selectOneAlcohol() arg:" +priceBorderNo);
        AlcoholPriceListDTO result = null;
		String query = "SELECT * FROM tb_alcohol WHERE PRICE_BORDER_NO = ?";
		System.out.println("AlcoholPriceListDAO  :" + priceBorderNo);
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(query);
            pstmt.setString(1, priceBorderNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new AlcoholPriceListDTO(
						rset.getInt("PRICE_BORDER_NO"),
						rset.getString("BORDER_KIND"),
						rset.getString("PRODUCT_NAME"), 
						rset.getString("RIPENING"), 
						rset.getString("PRICE"),
						rset.getString("CAPACITY"), 
						rset.getString("DATE_OF_PURCHASE"), 
						rset.getString("MARKET"),
						rset.getString("NOTE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("AlcoholPriceListDAO: return: "+ result);
		return result;
	}
	
	public List<AlcoholPriceListDTO> selectListAlcohol(Connection conn, String priceBorderNo, String searchWord) {
		List<AlcoholPriceListDTO>  result = new ArrayList<AlcoholPriceListDTO>();
		String query = "select * from TB_ALCOHOL where PRICE_BORDER_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, priceBorderNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				AlcoholPriceListDTO vo = new AlcoholPriceListDTO(rset.getInt("PRICE_BORDER_NO"), 
						rset.getString("BORDER_KIND"),
						rset.getString("PRODUCT_NAME"), 
						rset.getString("RIPENING"), 
						rset.getString("PRICE"),
						rset.getString("CAPACITY"), 
						rset.getString("DATE_OF_PURCHASE"), 
						rset.getString("MARKET"),
						rset.getString("NOTE"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("AlcoholPriceListDAO // selectListAlcohol 진입");
		return result;
	}

//	public List<AlcoholPriceListDTO> selectListAlcohol(Connection conn, String borderKind) {
//		List<AlcoholPriceListDTO>  result = new ArrayList<AlcoholPriceListDTO>();
//		String query = "select * from TB_ALCOHOL where BORDER_KIND=?";
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, borderKind);
//			rset = pstmt.executeQuery();
//			while (rset.next()) {
//				AlcoholPriceListDTO vo = new AlcoholPriceListDTO(
//						rset.getInt("PRICE_BORDER_NO"), 
//						rset.getString("BORDER_KIND"),
//						rset.getString("PRODUCT_NAME"), 
//						rset.getString("RIPENING"), 
//						rset.getString("PRICE"),
//						rset.getString("CAPACITY"), 
//						rset.getString("DATE_OF_PURCHASE"), 
//						rset.getString("MARKET"),
//						rset.getString("NOTE"));
//				result.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		return result;
//		
//	}

		public List<AlcoholPriceListDTO> selectListAlcohol(String searchWord){
			String query = "select * from tb_Alcohol where BORDER_KIND like ? or PRODUCT_NAME like ?";
			List<AlcoholPriceListDTO> result = null;
			Connection conn = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			try {
				pstmt = conn.prepareStatement(query);
				searchWord = "%" + searchWord + "%" ;
				pstmt.setString(1,searchWord);
				pstmt.setString(2,searchWord);
				rset = pstmt.executeQuery();
				result = new ArrayList<AlcoholPriceListDTO>();
				while (rset.next()) {
					AlcoholPriceListDTO vo = new AlcoholPriceListDTO(
							rset.getInt("PRICE_BORDER_NO"), 
							rset.getString("BORDER_KIND"),
							rset.getString("PRODUCT_NAME"), 
							rset.getString("RIPENING"), 
							rset.getString("PRICE"),
							rset.getString("CAPACITY"), 
							rset.getString("DATE_OF_PURCHASE"), 
							rset.getString("MARKET"),
							rset.getString("NOTE"));
					result.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return result;
			
		}

	public List<AlcoholPriceListDTO> selectListAlcohol(Connection conn, int currentPage, int pageSize, int totalCnt){
		List<AlcoholPriceListDTO> result = new ArrayList<AlcoholPriceListDTO>();
		String query="select * from (select tb1.*, rownum rn from (select * from tb_Alcohol order by PRICE_BORDER_NO asc) tb1) tb2\r\n"
				+ " where rn between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRownum = 0;
		int endRownum = 0;
		
		//test**
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : "+ pageSize);
		System.out.println("총글개수 : "+ totalCnt);
		//test**
		
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt : (currentPage*pageSize);
		System.out.println("startRownum:" + startRownum);
		System.out.println("endRownum:" + endRownum);
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				AlcoholPriceListDTO vo = new AlcoholPriceListDTO(
						rset.getInt("PRICE_BORDER_NO"), 
						rset.getString("BORDER_KIND"),
						rset.getString("PRODUCT_NAME"), 
						rset.getString("RIPENING"), 
						rset.getString("PRICE"),
						rset.getString("CAPACITY"), 
						rset.getString("DATE_OF_PURCHASE"), 
						rset.getString("MARKET"),
						rset.getString("NOTE"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	
	
	public int queryTotalCnt() {
	int result = 0;
	String queryTotalCnt = "select count(*) cnt from TB_ALCOHOL";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null; 

	try {
		conn = getconnection();
		pstmt = conn.prepareStatement(queryTotalCnt);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			result = rset.getInt("cnt");
		}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
		close(conn);
	}
	System.out.println("총글개수 : "+result);
	return result;
	
	}
	
	
	public int getCount(Connection conn) {
		int result = 0 ;
		String queryTotalCnt = "select count(*) cnt from tb_Alcohol";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalCnt = 0;
		try {
			pstmt = conn.prepareStatement(queryTotalCnt);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCnt = rs.getInt("cnt");
			}
			System.out.println("a 총글개수 : " + totalCnt);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}System.out.println("b 총글개수 : "+totalCnt);
		return totalCnt;
	}
	
	
	
	public int insertAlcohol(Connection conn, AlcoholPriceListDTO vo) {
		int result = 0 ;
		//TODO
		return result;
	}
	
	
	public List<AlcoholPriceListDTO> selectListAlcohol(Connection conn, String searchWord){
		List<AlcoholPriceListDTO> result = null;
		return result;
	}
	

	public int getTotalCount(Connection conn) {
		int result = 0;
		//TODO
		return result;
	}
	
	public int getSearchTotalCount(Connection conn, String searchWord) {
		int result = 0;
		//TODO
		return result;
	}
	
	public Map<String, Object> selectListAlcohol(int currentPage, int pageSize){
		Map<String, Object> result = null;
		//TODO
		return result;
	}
	
	

}