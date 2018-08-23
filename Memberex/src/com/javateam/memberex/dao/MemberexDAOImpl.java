/**
 * 
 */
package com.javateam.memberex.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javateam.memberex.dao.MemberexDAOImpl;
import com.javateam.memberex.meta.ExceptionMetadata;
import com.javateam.memberex.util.MemberexDbUtil;
import com.javateam.memberex.vo.MemberexVO;

/**
 * @author a
 *
 */
public class MemberexDAOImpl implements MemberexDAO{

	private static MemberexDAOImpl instance = null;
	
	private MemberexDAOImpl() {}
	
	public static final MemberexDAOImpl getInstance1() {
		
		if(instance == null) {
			instance = new MemberexDAOImpl();
		}
		
		return instance;
	}
	
	@Override
	public void insertMember(MemberexVO member) {
		
	      // 1. DB 연결 객체 활성화 <= 연결 메스드
	      Connection con = MemberexDbUtil.connect();

	      // 2. SQL처리 객체 생성
	      PreparedStatement pstmt = null;

	      // 3. SQL 구문
	      String sql = "INSERT INTO member_table1 VALUES " + "(?,?,?,?,?,?,?,?,?,TO_DATE (? , 'yyyy-mm-dd'), SYSDATE)";

	      try {
	         // 4. SQL 구문 처리 / 예외처리(try~catch~finally)
	         pstmt = con.prepareStatement(sql);

	         // 5. SQL 구문 인자 처리(대입)
	         pstmt.setString(1, member.getId());
	         pstmt.setString(2, member.getPw());
	         pstmt.setString(3, member.getName());
	         pstmt.setString(4, member.getGender());
	         pstmt.setString(5, member.getEmail());
	         pstmt.setString(6, member.getMobile());
	         pstmt.setString(7, member.getPhone());
	         pstmt.setString(8, member.getZip());
	         pstmt.setString(9, member.getAddress());
	         pstmt.setString(10, member.getBirthday());
	         

	         // 6. SQL 구문실행
	         if (pstmt.executeUpdate() == 1)// 1일 경우 성공적으로 실행
	            System.out.println("회원정보 저장에 성공하였습니다.");
	         else
	            System.out.println("회원정보 저장에 실패하였습니다.");

	      } catch (SQLException e) {
	         System.out.println("MemberDAOImpl insertMember SE :");
	         e.printStackTrace();
	      } catch (Exception e) {
	         System.out.println("MemberDAOImpl insertMember E : ");
	         e.printStackTrace();
	      }finally {
	         //7.DB 연결 해제( 자원반납)
	    	  MemberexDbUtil.close(con, pstmt, null);
	      }
	   }// INSERT

	@Override
	public void updateMember(MemberexVO member) throws Exception {
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		Connection con = MemberexDbUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "UPDATE member_table1 SET pw = ?, name = ?, gender = ?, email = ?, mobile = ?, phone = ?, "
				   + "zip = ?, address = ?, birthday = ? WHERE id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,member.getPw());
			pstmt.setString(2,member.getName());
			pstmt.setString(3,member.getGender());
			pstmt.setString(4,member.getEmail());
			pstmt.setString(5,member.getMobile());
			pstmt.setString(6,member.getPhone());
			pstmt.setString(7,member.getZip());
			pstmt.setString(8,member.getAddress());
			pstmt.setString(9,member.getBirthday());
			pstmt.setString(10,member.getId());
			if(pstmt.executeUpdate() == 1) {
				System.out.println("회원 정보 수정에 성공하였습니다.");
			}else {
				System.out.println("회원 정보 수정에 실패하였습니다.");
			}
		} catch(SQLException e) {
			emd.printErr(e, con, true);
		}catch (Exception e) {
			emd.printErr(e, con, true);
            e.printStackTrace();
        } finally {
            // 7. DB 연결 해제(자원 반납)
        	MemberexDbUtil.close(con, pstmt, null);
        }
		
		
	}
	
	@Override
	public List<MemberexVO> getAllMembers() throws Exception {
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		Connection con = MemberexDbUtil.connect(); // DB 연결
        ArrayList<MemberexVO> list = new ArrayList<MemberexVO>();
        PreparedStatement pstmt = null; // SQL 처리 객체
        ResultSet rs = null; // SQL 결과셋 객체
        String sql = "SELECT * FROM member_table1";
        try {
            pstmt = con.prepareStatement(sql); // SQL 구문 처리
            rs = pstmt.executeQuery(); // SQL 구문 실행 -> 결과셋     
            // if (rs.next()) {
            while (rs.next()) {
               MemberexVO member = new MemberexVO();
                // member.setId(rs.getString(1)); // (O)
               member.setId(rs.getString("id")); // (O)
               member.setPw(rs.getString("pw"));
               member.setName(rs.getString("name"));
               member.setGender(rs.getString("gender"));
               member.setEmail(rs.getString("email"));
               member.setMobile(rs.getString("mobile"));
               member.setPhone(rs.getString("phone"));
               member.setZip(rs.getString("zip"));
               member.setAddress(rs.getString("address"));
               member.setBirthday(rs.getString("birthday"));
               member.setJoindate(rs.getString("joindate"));
               list.add(member);
            } //
        } catch (SQLException e) {
        	emd.printErr(e, con, true);
        } catch (Exception e) {
        	emd.printErr(e, con, true);
        } finally {
        	MemberexDbUtil.close(con, pstmt, rs);
        } //
       for(int i = 0; i < list.size(); i++) {
    	   System.out.println(list.get(i));
       }
       return list;
	}

	@Override
	public MemberexVO getMember(String id) throws Exception {
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		Connection con = MemberexDbUtil.connect();
        MemberexVO member = new MemberexVO();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM member_table1 "
                   + "WHERE id=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,  id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setName(rs.getString("name"));
                member.setGender(rs.getString("gender"));
                member.setEmail(rs.getString("email"));
                member.setMobile(rs.getString("mobile"));
                member.setPhone(rs.getString("phone"));
                member.setZip(rs.getString("zip"));
                member.setAddress(rs.getString("address"));
                member.setBirthday(rs.getString("birthday"));
                member.setJoindate(rs.getString("joindate"));
            }
        } catch (SQLException e) {
        	emd.printErr(e, con, true);
        } catch (Exception e) {
        	emd.printErr(e, con, true);
        } finally {
        	MemberexDbUtil.close(con, pstmt, rs);
        }
        return member;
		
	}

	@Override
	public void deleteMember(String id) throws Exception {
		
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		Connection con = MemberexDbUtil.connect();		
		PreparedStatement pstmt = null;	
		String sql = "DELETE FROM member_table1 WHERE id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);		
			pstmt.setString(1,id);	
			if(pstmt.executeUpdate() == 1) {
				System.out.println("회원 정보 삭제에 성공하였습니다.");
			}else {
				System.out.println("회원 정보 삭제에 실패하였습니다.");
				
			}
		} catch(SQLException e) {
			emd.printErr(e, con, true);
		}catch (Exception e) {
			emd.printErr(e, con, true);
        } finally {
        	MemberexDbUtil.close(con, pstmt, null);
        }
	}

	@Override
	public boolean isMember(String id) throws Exception {
		
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		Connection con = MemberexDbUtil.connect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT count(*) FROM member_table1 WHERE id = ?";
        boolean check = true;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,  id);      
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	if(rs.getInt("COUNT(*)") == 0) {
            		check = false;
            		System.out.println("해당 ID의 회원정보가 존재하지 않습니다.");
            	}else {
            		System.out.println("해당 ID의 회원정보가 존재합니다.");
            	}
            	
            }
            
        } catch (SQLException e) {
        	emd.printErr(e, con, true);
        } catch (Exception e) {
        	emd.printErr(e, con, true);
        } finally {
        	MemberexDbUtil.close(con, pstmt, rs);
        }
       
        return check;
		
	}

	@Override
	public boolean isMember(String id, String password) throws Exception {
		
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		Connection con = MemberexDbUtil.connect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT count(*) FROM member_table1 WHERE id = ? AND pw = ?";
        boolean check = true;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,  id);
            pstmt.setString(2,  password);
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	if(rs.getInt("COUNT(*)") == 0) {
            		check = false;
            		System.out.println("해당 ID,PW의 회원정보가 존재하지 않습니다.");
            	}else {
            		System.out.println("해당 ID,PW의 회원정보가 존재합니다.");
            	}
            }
        } catch (SQLException e) {
        	emd.printErr(e, con, true);
        } catch (Exception e) {
        	emd.printErr(e, con, true);
        } finally {
        	MemberexDbUtil.close(con, pstmt, rs);
        } 
        return check;
	}

	@Override
	public int getRowCount() throws Exception {
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		Connection con = MemberexDbUtil.connect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT count(*) FROM member_table1";
        int rc = 0;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	rc = rs.getInt("count(*)");
            } 
        } catch (SQLException e) {
        	emd.printErr(e, con, true);
        } catch (Exception e) {
        	emd.printErr(e, con, true);
        } finally {
        	MemberexDbUtil.close(con, pstmt, rs);
        } 
		return rc;
	}

	@Override
	public MemberexVO[] getAllMembersArray() throws Exception {
		
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
		MemberexVO[] mbvo = new MemberexVO[this.getRowCount()];
		Connection con = MemberexDbUtil.connect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM member_table1";
        int x = 0;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	MemberexVO member = new MemberexVO();
            	member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setName(rs.getString("name"));
                member.setGender(rs.getString("gender"));
                member.setEmail(rs.getString("email"));
                member.setMobile(rs.getString("mobile"));
                member.setPhone(rs.getString("phone"));
                member.setZip(rs.getString("zip"));
                member.setAddress(rs.getString("address"));
                member.setBirthday(rs.getString("birthday"));
                member.setJoindate(rs.getString("joindate"));
            	mbvo[x++] = member;
            } //
        } catch (SQLException e) {
        	emd.printErr(e, con, true);
        } catch (Exception e) {
        	emd.printErr(e, con, true);
        } finally {
            MemberexDbUtil.close(con, pstmt, rs);
        } //
       for(int i = 0; i < this.getRowCount(); i++) {
    	   System.out.println(mbvo[i]);
       }
		return mbvo;
		
	}

	@Override
	public void getMemberInfo() throws Exception {
		Connection con = MemberexDbUtil.connect();
	    DatabaseMetaData dbmd = con.getMetaData();
	    ResultSet rs = null;
	    ResultSetMetaData rsmd = null;
	    PreparedStatement pstmt = null;
	    String sql = "SELECT * FROM member_table1";
	   
	    pstmt = con.prepareStatement(sql);
	    rs = pstmt.executeQuery();
	   
	    rsmd = rs.getMetaData();
	   
	    System.out.println("DB 종류 : "+dbmd.getDatabaseProductName());
	    System.out.println("DB 버전1 : "+dbmd.getDatabaseMajorVersion()+"."
	                                  +dbmd.getDatabaseMinorVersion());
	    System.out.println("DB 버전(full) : "+dbmd.getDatabaseProductVersion());
	    System.out.println("DB JDBC 드라이버 버전 : "+dbmd.getDriverMajorVersion()+"."
	                                              +dbmd.getDriverMinorVersion());
	   
	    System.out.println("컬럼의 수 : "+ rsmd.getColumnCount());
	    System.out.println("컬럼 라벨명 : "+ rsmd.getColumnLabel(1));
	    System.out.println("컬럼 라벨명 : "+ rsmd.getColumnLabel(2));
	    System.out.println("컬럼명 : "+ rsmd.getColumnName(1));
	    System.out.println("컬럼명 : "+ rsmd.getColumnName(2));
	    System.out.println("컬럼 타입 : "+ rsmd.getColumnTypeName(1));
	    System.out.println("컬럼 타입 : "+ rsmd.getColumnTypeName(5));
	    System.out.println("컬럼 타입 대응 클래스명 : "+rsmd.getColumnClassName(1));
	   
	    ResultSet pks = dbmd.getPrimaryKeys(null, null, "member_table1");
	   
	    while (pks.next()) {
	       
	        System.out.println("현재 테이블 기본키명 : "+pks.getString("COLUMN_NAME"));
	        // index = 4
	        System.out.println("현재 계정명 : " + pks.getString("TABLE_SCHEM")); // index = 2
	        System.out.println("현재 테이블명 : " +pks.getString("TABLE_NAME")); // index = 3
	        System.out.println("현재 키 시퀀스 : " +pks.getString("KEY_SEQ")); // index = 5
	        System.out.println("현재 기본키 제약조건명 : " +pks.getString("PK_NAME"));
	        // index = 6
	       
	    } // while
	   
	    // System.out.println("Member 테이블 기본키 : "
	    //                + (pks.next() ? pks.getString("COLUMN_NAME") : "없음"));
	   
	    MemberexDbUtil.close(con, pstmt, rs); 
		
	}


}
