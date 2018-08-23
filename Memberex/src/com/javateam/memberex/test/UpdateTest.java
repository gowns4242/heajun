/**
 * 
 */
package com.javateam.memberex.test;

import com.javateam.memberex.dao.MemberexDAO;
import com.javateam.memberex.dao.MemberexDAOImpl;
import com.javateam.memberex.vo.MemberexVO;

/**
 * @author a
 *
 */
public class UpdateTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		// 1. DAO 객체 생성
        MemberexDAO dao = MemberexDAOImpl.getInstance1();
       
        // 2. 회원 정보 준비
        MemberexVO member
            = new MemberexVO("jsp1234", "12345678","길동이","남","abce@masd.com",
    				"010-2020-3030","032-303-3023","23456", "한국1차아파트", "19950530");
       
        // 3. DAO method(CRUD) 호출(실행)
        dao.updateMember(member);

	}

}
