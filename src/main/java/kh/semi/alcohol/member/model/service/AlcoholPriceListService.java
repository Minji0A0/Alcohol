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

	
	public AlcoholPriceListDTO selectOneAlcohol(String borderKind) {
		Connection conn = getconnection();
		AlcoholPriceListDTO result = dao.selectOneAlcohol(conn, borderKind);
		close(conn);
		return result;
	}
	
	public Map<String, Object> selectListAlcohol(int currentPage, int pageSize){
		Connection conn = getconnection();
		int totalCnt = dao.getTotalCount(conn);
		System.out.println("[ service selectListAlcohol ] currentPage : " + currentPage);
		System.out.println("[ service selectListAlcohol ] pageSize : "+ pageSize);
		System.out.println("[ service selectListAlcohol ] totalCnt : "+ totalCnt);
		
		List<AlcoholPriceListDTO> result = dao.selectListAlcohol(conn,currentPage,pageSize,totalCnt);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt",  totalCnt);
		map.put("alcoholList", result);
		System.out.println("[ service selectListAlcohol ] return : "+ map);
		return map;
	}
	public Map<String, Object> selectListAlcohol(int currentPage, int pageSize, String searchWord){
		Connection conn = getconnection();
		
		int totalCnt = dao.getSearchTotalCount(conn, searchWord);
		System.out.println("[ service selectListAlcohol ] searchWord : " + searchWord);
		System.out.println("[ service selectListAlcohol ] currentPage : " + currentPage);
		System.out.println("[ service selectListAlcohol ] pageSize : "+ pageSize);
		System.out.println("[ service selectListAlcohol ] totalCnt : "+ totalCnt);
		
		List<AlcoholPriceListDTO> result = dao.selectListAlcohol(conn, currentPage, pageSize, totalCnt, searchWord);
		
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("alcoholList", result);
		System.out.println("[ service selectListAlcohol ] return : "+ map);
		return map;
	}
	
	public int insertStudent(AlcoholPriceListDTO vo) {
		int result = 0;
		Connection conn = getconnection();
		result = dao.insertAlcohol(conn,vo);
		close(conn);
		return result;
	}
}