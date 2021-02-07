package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBconnection;
import model.UserDTO;

public class UserDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public static String sessionID = null;
	
	//관리 계정 체크 (목사님(관리자계정), 임원, 새가족팀)
	
	public int login (String id, String pw) {
		int result = 0;
		//관리자 (목사님,임원) 계정일경우
		if(id.equals("admin") && pw.equals("admin1234")) {
			result = 1;
			sessionID = id;
		//새가족 계정일경우
		} else if (id.equals("newface")&& pw.equals("newface12")) {
			result =2;
			sessionID = id;
		} else {
			result = 3;
		}
		return result;
	}
	
	public boolean logout () {
		boolean check = false;
		if (sessionID != null) {
			sessionID = null;
			check = true;
		}
		return check;
	}
	
	//청년부 등록
	
	public boolean signUp (UserDTO dto) {
		
		//번호, 이름, 핸드폰, 또래, 등급, 또래장
		String sql = "INSERT INTO churchmember VALUES (member_seq.nextval, ?,?,?,?,?)";
		boolean check = false;
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhonenum());
			pstmt.setString(3, dto.getAge());
			pstmt.setString(4, dto.getGrade());
			pstmt.setString(5, dto.getChief());
			if (pstmt.executeUpdate() ==1 ) {
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
		
	}
	
	//청년부 수정
	
	public boolean update (String phonenum, String new_name, String new_phonenum, String new_age, String new_grade, String new_chief) {
		//이름을 입력 받아서 업데이트 
		String sql = "UPDATE CHURCHMEMBER SET NAME = ? PHONENUM = ? AGE = ? GRADE = ? CHIEF = ? WHERE PHONENUM =?";
		boolean check = false;
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_name);
			pstmt.setString(2, new_phonenum);
			pstmt.setString(3, new_age);
			pstmt.setString(4, new_grade);
			pstmt.setString(5, new_chief);
			pstmt.setString(6, phonenum);
			
			if(pstmt.executeUpdate() ==1) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
		
	}
	//청년부 삭제
	public boolean delete (String phonenum) {
		String sql = "DELETE FROM CHURCHMEMBER WHERE PHONENUM = ?";
		boolean check = false;
		
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phonenum);
			
			if ( pstmt.executeUpdate() ==1 ) {
				check = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	public UserDTO findMember (String name) {
		UserDTO user = null;
		String sql = "SELECT * FROM CHURCHMEMBER WHERE NAME = ?";
		
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user = new UserDTO();
				user.setName(rs.getString(2));
				user.setPhonenum(rs.getString(3));
				user.setAge(rs.getString(4));
				user.setGrade(rs.getString(5));
				user.setChief(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	//청년부전체 조회
	public ArrayList<UserDTO> FindMemberAll () {
		ArrayList<UserDTO> members = new ArrayList<UserDTO>();
		String sql = "SELECT * FROM CHURCHMEMBER";
		
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserDTO member = new UserDTO();
				member.setName(rs.getString("NAME"));
				member.setPhonenum(rs.getString("PHONENUM"));
				member.setAge(rs.getString("AGE"));
				member.setGrade(rs.getString("GRADE"));
				member.setChief(rs.getString("CHIEF"));
				members.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return members;
	}
}













