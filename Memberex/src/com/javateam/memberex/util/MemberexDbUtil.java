/**
 * 
 */
package com.javateam.memberex.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * DB 연결/해제 클래스
 * @author a
 *
 */
public class MemberexDbUtil {
	
	/**
	 * DB 연결
	 * @return 연결객체
	 */
	public static Connection connect() {
		
		Connection con = null; //DB 연결객체
		final String driver = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String id = "java"; // 계정 아이디
		final String pw = "java"; // 계정 비밀번호
		
		try {
			// JDBC 검색/로딩(loading)
			Class.forName(driver);
			// DB 연결을 실질적으로 객체 반환
			con = DriverManager.getConnection(url, id, pw);
			
		}catch(ClassNotFoundException e) {
			System.out.println("DbUtil connect CNFE :");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("DbUtil connect SE : ");
			e.printStackTrace();
		}
		return con;
	} // connect
	
	/**
	 * DB 연결 해제(자원 반납)
	 * 
	 * @param con 연결 객체
	 * @param pstmt SQL 처리 객체
	 * @param rs SQL 처리 결과셋
	 */
	public static void close(Connection con,
							 PreparedStatement pstmt,
							 ResultSet rs) {
		try {
//			if(!rs.isClosed())rs.close();
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			
		}catch(SQLException e) {
			System.out.println("DbUtil close SE : ");
			e.printStackTrace();
		}//
	}
	
}
