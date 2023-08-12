package kh.semi.alcohol.member.model.service;

import java.sql.Connection;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dao.MemberDAO;
import kh.semi.alcohol.member.model.dto.MemberDTO;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	// 로그인
	public MemberDTO selectOne(String userId, String userPw) {
		MemberDTO result = null;
		Connection conn = JDBCTemp.getconnection();
		result = dao.selectOne(conn, userId, userPw);
		JDBCTemp.close(conn);
		return result;
	}
	
	// 회원가입
    public boolean registerMember(MemberDTO member) {
        Connection conn = JDBCTemp.getconnection();
        int result = dao.insertMember(conn, member);
        JDBCTemp.close(conn);

        return result > 0; // Return true if insert was successful, false otherwise
    }
}
	
