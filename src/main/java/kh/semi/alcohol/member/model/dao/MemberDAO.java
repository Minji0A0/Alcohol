package kh.semi.alcohol.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dto.memberDTO;

public class MemberDAO {

	public memberDTO selectOne(Connection conn, String userId, String userPw) {

//	-------------- -------- ------------- 
//	USER_ID        NOT NULL VARCHAR2(20)  
//	USER_NAME      NOT NULL VARCHAR2(50)  
//	USER_PW        NOT NULL VARCHAR2(20)  
//	USER_EMAIL              VARCHAR2(255) 
//	USER_HOME               VARCHAR2(255) 
//	USER_CELLPHONE          NUMBER        
//	USER_HOMEPHONE          NUMBER     

		memberDTO result = null;
		String query = "select * from TB_MEMBER where USER_ID=? and USER_PW=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new memberDTO(rs.getString("USER_ID"), rs.getString("USER_NAME"),
						rs.getString("USER_EMAIL"), rs.getString("USER_HOME"), rs.getInt("USER_CELLPHONE"),
						rs.getInt("USER_HOMEPHONE"));
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
