/**
 * 
 */
package com.javateam.memberex.test;

import java.util.List;

import com.javateam.memberex.dao.MemberexDAO;
import com.javateam.memberex.dao.MemberexDAOImpl;
import com.javateam.memberex.vo.MemberexVO;

/**
 * @author a
 *
 */
public class GetAllMembersTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		MemberexDAO dao = MemberexDAOImpl.getInstance1();
		List<MemberexVO> members = dao.getAllMembers();
		

	}

}
