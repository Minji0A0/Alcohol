package kh.semi.alcohol.member.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.semi.alcohol.member.model.dao.AlcoholPriceListDAO;
import kh.semi.alcohol.member.model.dto.AlcoholPriceListDTO;

import static kh.semi.alcohol.common.JDBCTemp.*;

public class AlcoholPriceListService {

	private AlcoholPriceListDAO dao = new AlcoholPriceListDAO();
	
	public int insertStudent(AlcoholPriceListDTO vo) {
		int result = 0;
		Connection conn = getconnection();
		result = dao.insertAlcohol(conn,vo);
		close(conn);
		return result;
	}
	
	public AlcoholPriceListDTO selectOneAlcohol(String borderKind) {
		Connection conn = getconnection();
		AlcoholPriceListDTO result = dao.selectOneAlcohol(conn, borderKind);
		close(conn);
		return result;
	}
	
	public AlcoholPriceListDTO selectOneAlcohol(int currentPage, int pageSize) {
		Connection conn = getconnection();
		AlcoholPriceListDTO result = dao.selectOneAlcohol(conn,currentPage, pageSize);
		close(conn);
		return result;
	}

	public List<AlcoholPriceListDTO> selectListAlcohol() {
		Connection conn = getconnection();
		List<AlcoholPriceListDTO> result = dao.selectListAlcohol(conn);
		close(conn);
		return result;
	}
	
	public List<AlcoholPriceListDTO> selectListAlcohol(String searchWord) {
		Connection conn = getconnection();
		List<AlcoholPriceListDTO> result = dao.selectListAlcohol(conn, searchWord);
		close(conn);
		return result;
	}
	
	public Map<String, Object> selectListAlcohol(int currentPage, int pageSize){
		Connection conn = getconnection();
		int totalCnt = dao.getCount(conn);
		System.out.println("service currentPage : " + currentPage);
		System.out.println("service pageSize : "+ pageSize);
		System.out.println("service 총글개수 : "+ totalCnt);
		List<AlcoholPriceListDTO> result = dao.selectListAlcohol(conn,currentPage,pageSize,totalCnt);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt",  totalCnt);
		map.put("studentList", result);
		return map;
	}
	public Map<String, Object> selectListAlcohol(int currentPage, int pageSize, String searchWord){
		Connection conn = getconnection();
		int totalCnt = dao.getSearchTotalCount(conn, searchWord);
		List<AlcoholPriceListDTO> result = dao.selectListAlcohol(conn,currentPage, pageSize, totalCnt);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("studentList", result);
		return map;
	}
	
	public int getTotalCount() {
		Connection conn = getconnection();
		int result = dao.getTotalCount(conn);
		close(conn);
		return result;
	
	}
}