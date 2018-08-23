/**
 * 
 */
package com.javateam.memberex.test;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import com.javateam.memberex.dao.MemberexDAO;
import com.javateam.memberex.dao.MemberexDAOImpl;
import com.javateam.memberex.vo.MemberexVO;

/**
 * @author a
 *
 */
public class MemberexInsertTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		
		// 1. DAO 객체 생성
		MemberexDAO dao = MemberexDAOImpl.getInstance1();

		
		// 2. 회원정보 준비
		MemberexVO member = new MemberexVO("jsp1234", "12345678","길동이","남","abce@masd.com",
				"010-2020-3030","032-303-3023","23456", "한국5차아파트", "19950530");
		
		dao.updateMember(member); //회원 정보 수정
		
		// 3. DAO method(CRUD) 호출(실행)
		dao.insertMember(member);
		
	}

}
