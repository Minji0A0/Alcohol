package kh.semi.alcohol.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dto.AlcoholDTO;
import kh.semi.alcohol.member.model.dto.JoinDTO;

public class JoinDAO {
	
	public List<JoinDTO> selectList(Connection conn, String userId, String userPw) {

//		-------------- -------- ------------- 
//		USER_ID        NOT NULL VARCHAR2(20)  
//		USER_NAME      NOT NULL VARCHAR2(50)  
//		USER_PW        NOT NULL VARCHAR2(20)  
//		USER_EMAIL              VARCHAR2(255) 
//		USER_HOME               VARCHAR2(255) 
//		USER_CELLPHONE          NUMBER        
//		USER_HOMEPHONE          NUMBER     
		
			List<JoinDTO> result = new ArrayList<JoinDTO>();
			String query = "select * from TB_MEMBER where USER_ID=? and USER_PW=?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				pstmt.setString(2, userPw);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					JoinDTO vo = new JoinDTO(rs.getString("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_PW"),
							rs.getString("USER_EMAIL"), rs.getString("USER_HOME"), rs.getInt("USER_CELLPHONE"),
							rs.getInt("USER_HOMEPHONE"));
					result.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemp.close(rs);
				JDBCTemp.close(pstmt);
			}
			return result;
		}

	public JoinDTO selectOne(Connection conn, String userId, String userPw) {

//	-------------- -------- ------------- 
//	USER_ID        NOT NULL VARCHAR2(20)  
//	USER_NAME      NOT NULL VARCHAR2(50)  
//	USER_PW        NOT NULL VARCHAR2(20)  
//	USER_EMAIL              VARCHAR2(255) 
//	USER_HOME               VARCHAR2(255) 
//	USER_CELLPHONE          NUMBER        
//	USER_HOMEPHONE          NUMBER     

		JoinDTO result = null;
		String query = "select * from TB_MEMBER where USER_ID=? and USER_PW=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new JoinDTO(rs.getString("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_PW"),
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

