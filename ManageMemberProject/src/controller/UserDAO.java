package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBconnection;
import model.UserDTO;

public class UserDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//청년부 등록
	
	public void signUp (UserDTO dto) {
		conn = DBconnection.getConnection();
		//번호, 이름, 핸드폰, 또래, 등급, 또래장
		String sql = "INSERT INTO churchmember VALUES (member_seq.nextval, ?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhonenum());
			pstmt.setString(3, dto.getAge());
			pstmt.setString(4, dto.getGrade());
			pstmt.setString(5, dto.getChief());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBconnection.dbClose(rs, pstmt, conn);
		}
		System.out.println("청년부 등록 완료");
		
	}
	
	//청년부 수정
	
	public void update (UserDTO dto, String name) {
		conn = DBconnection.getConnection();
		//이름을 입력 받아서 업데이트 
		String sql = "";
	}
	//청년부 삭제
	
	//청년부 조회
	
}
