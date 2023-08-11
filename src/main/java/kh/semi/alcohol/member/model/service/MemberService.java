package kh.semi.alcohol.member.model.service;

import java.sql.Connection;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dao.MemberDAO;
import kh.semi.alcohol.member.model.dto.memberDTO;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	public memberDTO selectOne(String userId, String userPw) {
		memberDTO result = null;
		Connection conn = JDBCTemp.getconnection();
		result = dao.selectOne(conn, userId, userPw);
		JDBCTemp.close(conn);
		return result;
	}
	
}
