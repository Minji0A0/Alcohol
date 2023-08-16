package kh.semi.alcohol.member.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.semi.alcohol.member.model.dao.AlcoholDAO;
import kh.semi.alcohol.member.model.dto.AlcoholDTO;

import static kh.semi.alcohol.common.JDBCTemp.*;

public class AlcoholService {

//	private AlcoholDAO dao = new AlcoholDAO();
//
//	public int insertStudent(AlcoholDTO vo) {
//		int result = 0;
//		Connection conn = getconnection();
//		result = dao.insertAlcohol(conn,vo);
//		close(conn);
//		return result;
//	}
//	
//	public AlcoholDTO selectOneAlcohol(String borderKind) {
//		Connection conn = getconnection();
//		AlcoholDTO result = dao.selectOneAlcohol(conn, borderKind);
//		close(conn);
//		return result;
//	}
//	
//	public List<AlcoholDTO> selectListAlcohol() {
//		Connection conn = getconnection();
//		List<AlcoholDTO> result = dao.selectListAlcohol(conn);
//		close(conn);
//		return result;
//	}
//	
//	public List<AlcoholDTO> selectListAlcohol(String searchWord) {
//		Connection conn = getconnection();
//		List<AlcoholDTO> result = dao.selectListAlcohol(conn, searchWord);
//		close(conn);
//		return result;
//	}
//	
//	public Map<String, Object> selectListStudent(int currentPage, int pageSize){
//		Connection conn = getconnection();
//		int totalCnt = dao.getCount(conn);
//		System.out.println("service currentPage : " + currentPage);
//		System.out.println("service pageSize : "+ pageSize);
//		System.out.println("service 총글개수 : "+ totalCnt);
//		List<AlcoholDTO> result = dao.selectListAlcohol(conn,currentPage,pageSize,totalCnt);
//		close(conn);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("totalCnt",  totalCnt);
//		map.put("studentList", result);
//		return map;
//	}
//	public Map<String, Object> selectListStudent(int currentPage, int pageSize, String searchWord){
//		Connection conn = getconnection();
//		int totalCnt = dao.getSearchTotalCount(conn, searchWord);
//		List<AlcoholDTO> result = dao.selectListAlcohol(conn,currentPage, pageSize, totalCnt);
//		close(conn);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("totalCnt", totalCnt);
//		map.put("studentList", result);
//		return map;
//	}
//	
//	public int getTotalCount() {
//		Connection conn = getconnection();
//		int result = dao.getTotalCount(conn);
//		close(conn);
//		return result;
//	
//	}
}