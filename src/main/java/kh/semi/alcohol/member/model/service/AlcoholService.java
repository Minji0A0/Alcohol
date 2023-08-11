package kh.semi.alcohol.member.model.service;

import java.sql.Connection;
import java.util.List;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dao.AlcoholDAO;
import kh.semi.alcohol.member.model.dao.MemberDAO;
import kh.semi.alcohol.member.model.dto.AlcoholDTO;

public class AlcoholService {

	private AlcoholDAO dao = new AlcoholDAO();


	public List<AlcoholDTO> selectList(String borderKind) {
		List<AlcoholDTO> result = null;
		Connection conn = JDBCTemp.getconnection();
		result = dao.selectList(conn, borderKind);
		JDBCTemp.close(conn);
		return result;
	}
	
	public AlcoholDTO selectOne(String borderKind, String productName, String price) {
		AlcoholDTO result = null;
		Connection conn = JDBCTemp.getconnection();
		result = dao.selectOne(conn, borderKind, productName, price);
		JDBCTemp.close(conn);
		return result;
	}
	
	
}

