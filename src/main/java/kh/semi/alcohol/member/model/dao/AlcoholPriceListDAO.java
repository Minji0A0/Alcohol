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

	// 상품 하나 상세보기
	public AlcoholPriceListDTO selectOneAlcohol(Connection conn, String priceBorderNo) {
		System.out.println("DAO selectOneAlcohol() arg:" + priceBorderNo);
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
				result = new AlcoholPriceListDTO(rset.getInt("PRICE_BORDER_NO"), rset.getString("BORDER_KIND"),
						rset.getString("PRODUCT_NAME"), rset.getString("RIPENING"), rset.getString("PRICE"),
						rset.getString("CAPACITY"), rset.getString("DATE_OF_PURCHASE"), rset.getString("MARKET"),
						rset.getString("NOTE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("AlcoholPriceListDAO: return: " + result);
		return result;
	}

	// 페이징 
	public List<AlcoholPriceListDTO> selectListAlcohol(Connection conn, int currentPage, int pageSize, int totalCnt) {
		System.out.println("[ DAO selectListAlcohol ] currentPage : " + currentPage);
		System.out.println("[ DAO selectListAlcohol ] pageSize : "+ pageSize);
		System.out.println("[ DAO selectListAlcohol ] totalCnt : "+ totalCnt);
		
		
		List<AlcoholPriceListDTO> result = new ArrayList<AlcoholPriceListDTO>();
		String query = "select * from (select tb1.*, rownum rn from (select * from tb_Alcohol order by PRICE_BORDER_NO asc) tb1) tb2 "
				+ " where rn between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage - 1) * pageSize + 1;
		endRownum = ((currentPage * pageSize) > totalCnt) ? totalCnt : (currentPage * pageSize);
		System.out.println("startRownum:" + startRownum);
		System.out.println("endRownum:" + endRownum);

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				AlcoholPriceListDTO vo = new AlcoholPriceListDTO(rset.getInt("PRICE_BORDER_NO"),
						rset.getString("BORDER_KIND"), rset.getString("PRODUCT_NAME"), rset.getString("RIPENING"),
						rset.getString("PRICE"), rset.getString("CAPACITY"), rset.getString("DATE_OF_PURCHASE"),
						rset.getString("MARKET"), rset.getString("NOTE"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("[ DAO selectListAlcohol ] return : "+ result);
		return result;
	}
	// 페이징 + 검색 : 진, 싱글몰트,... , 사파이어 상품명
	public List<AlcoholPriceListDTO> selectListAlcohol(Connection conn, int currentPage, int pageSize, int totalCnt, String searchWord) {
		System.out.println("[ DAO selectListAlcohol ] searchWord : " + searchWord);
		System.out.println("[ DAO selectListAlcohol ] currentPage : " + currentPage);
		System.out.println("[ DAO selectListAlcohol ] pageSize : "+ pageSize);
		System.out.println("[ DAO selectListAlcohol ] totalCnt : "+ totalCnt);
		
		String query = "select * from (select tb1.*, rownum rn from (select * from tb_Alcohol where BORDER_KIND like ? or PRODUCT_NAME like ? order by PRICE_BORDER_NO asc) tb1) tb2 "
				+ " where rn between ? and ?";
		
		List<AlcoholPriceListDTO> result = new ArrayList<AlcoholPriceListDTO>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage - 1) * pageSize + 1;
		endRownum = ((currentPage * pageSize) > totalCnt) ? totalCnt : (currentPage * pageSize);
		System.out.println("startRownum:" + startRownum);
		System.out.println("endRownum:" + endRownum);
		
		try {
			pstmt = conn.prepareStatement(query);
			searchWord = "%" + searchWord + "%";
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			pstmt.setInt(3, startRownum);
			pstmt.setInt(4, endRownum);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				AlcoholPriceListDTO vo = new AlcoholPriceListDTO(rset.getInt("PRICE_BORDER_NO"),
						rset.getString("BORDER_KIND"), rset.getString("PRODUCT_NAME"), rset.getString("RIPENING"),
						rset.getString("PRICE"), rset.getString("CAPACITY"), rset.getString("DATE_OF_PURCHASE"),
						rset.getString("MARKET"), rset.getString("NOTE"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("[ DAO selectListAlcohol searchword] return : "+ result);
		return result;

	}
	
	
	public int getTotalCount(Connection conn) {
		System.out.println("[ DAO getTotalCount ]");
		int result = 0;
		String query = "select count(*) cnt from TB_ALCOHOL";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("[ DAO getTotalCount ]return: "+result);
		return result;
	}

	public int getSearchTotalCount(Connection conn, String searchWord) {
		System.out.println("[ DAO getSearchTotalCount ]searchWord : "+ searchWord);
		int result = 0;
		String query = "select count(*) cnt from tb_Alcohol WHERE BORDER_KIND like ? or PRODUCT_NAME like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			searchWord = "%" + searchWord + "%";
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[ DAO getSearchTotalCount ]return: "+result);
		return result;
	}


	public int insertAlcohol(Connection conn, AlcoholPriceListDTO vo) {
		int result = 0;
		// TODO
		return result;
	}

}