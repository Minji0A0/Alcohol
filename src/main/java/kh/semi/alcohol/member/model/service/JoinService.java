package kh.semi.alcohol.member.model.service;

import java.sql.Connection;
import java.util.List;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dao.JoinDAO;
import kh.semi.alcohol.member.model.dto.JoinDTO;

public class JoinService {
	
	private JoinDAO dao = new JoinDAO();


	public List<JoinDTO> selectListAlcohol(Connection conn, String userId, String userPw) {
		List<JoinDTO> result = null;
		conn = JDBCTemp.getconnection();
		System.out.println("JoinService진입");
		result = dao.selectListAlcohol(conn, userId, userPw);
		JDBCTemp.close(conn);
		return result;
	}
	
	public JoinDTO selectOneAlcohol(Connection conn, String userId, String userPw) {
		JoinDTO result = null;
		conn = JDBCTemp.getconnection();
		result = dao.selectOneAlcohol(conn, userId, userPw);
		JDBCTemp.close(conn);
		return result;
	}

}
