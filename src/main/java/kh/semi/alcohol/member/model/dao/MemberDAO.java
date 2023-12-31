package kh.semi.alcohol.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dto.MemberDTO;

public class MemberDAO {

	public MemberDTO selectOne(Connection conn, String userId, String userPw) {

//	-------------- -------- ------------- 
//	USER_ID        NOT NULL VARCHAR2(20)  
//	USER_NAME      NOT NULL VARCHAR2(50)  
//	USER_PW        NOT NULL VARCHAR2(20)  
//	USER_EMAIL              VARCHAR2(255) 
//	USER_HOME               VARCHAR2(255) 
//	USER_CELLPHONE          NUMBER        
//	USER_HOMEPHONE          NUMBER     

		MemberDTO result = null;
		String query = "select * from TB_MEMBER where USER_ID=? and USER_PW=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			if (rs.next()) {//rs.getString("USER_PW"),는 차후 확인후 최종 삭제
				result = new MemberDTO(rs.getString("USER_ID"), rs.getString("USER_NAME"),rs.getString("USER_PW"), rs.getString("USER_EMAIL"),
						rs.getString("USER_HOME"), rs.getInt("USER_CELLPHONE"), rs.getInt("USER_HOMEPHONE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemp.close(rs);
			JDBCTemp.close(pstmt);
		}
		return result;
	}

	public int insertMember(Connection conn, MemberDTO member) {
		int result = 0;
		String query = "INSERT INTO TB_MEMBER(USER_ID, USER_NAME, USER_PW, USER_EMAIL, USER_HOME, USER_CELLPHONE, USER_HOMEPHONE) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserName());
			pstmt.setString(3, member.getUserPw());
			pstmt.setString(4, member.getUserEmail());
			pstmt.setString(5, member.getUserHome());
			pstmt.setInt(6, member.getUserCellphone());
			pstmt.setInt(7, member.getUserHomephone());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemp.close(pstmt);
		}

		return result;
	}
}
