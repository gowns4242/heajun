/**
 * 
 */
package com.javateam.memberex.dao;

import java.util.List;

import com.javateam.memberex.vo.MemberexVO;

/**
 * DAO
 * @author a
 *
 */
public interface MemberexDAO {

	/**
	 * 회원 정보 삽입
	 * 
	 * @param member 회원정보
	 * @throws Exception 예외처리
	 */
	void insertMember(MemberexVO member) throws Exception;
	
	/**
	 * 회원 정보 수정
	 * 
	 * @param member 회원정보
	 * @throws Exception 예외처리
	 */
	void updateMember(MemberexVO member) throws Exception;
	
	/**
	 * 전체 회원 정보 조회
	 * @return 전체 회원 정보
	 * @throws Exception 예외처리
	 */
	List<MemberexVO> getAllMembers() throws Exception;
	
	/**
	 * 개별 회원 정보 조회
	 * 
	 * @param id 회원 아이디
	 * @return 개별 회원 정보
	 * @throws Exception 예외처리 
	 */
	MemberexVO getMember(String id) throws Exception;
	
	/**
	 * 회원 정보 삭제
	 * 
	 * @param member 회원정보
	 * @throws Exception 예외처리
	 */
	
	void deleteMember(String id) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	boolean isMember(String id) throws Exception;
	
	/**
	 * 회원 존재 유무 점검
	 * ex) 로그인 인증(authenticarton)
	 * 
	 * @param id 회원 아이디
	 * @param password 회원 비밀번호
	 * @return 회원 존재 유무
	 * @throws Exception 예외처리
	 */
	
	boolean isMember(String id, String password) throws Exception;
	
	/**
	 * 
	 * @return 테이블의 전체 행수
	 * @throws Exception 예외처리
	 */
	int getRowCount() throws Exception;
	
	/**
	 * 
	 * @return 전체 회원(들) 정보
	 * @throws Exception 예외처리
	 */
	MemberexVO[] getAllMembersArray() throws Exception;
	
	/**
	 * 회원 정보 테이블 검색
	 * 
	 * @throws Exception 예외처리
	 */
	void getMemberInfo() throws Exception;
	
	/**
	 * SQL구문을 통해서 회원 정보 조회(검색)
	 * 
	 * @param sql SQL구문
	 * @return 회원 정보(들)
	 * @throws Exception 예외처리
	 */
}
