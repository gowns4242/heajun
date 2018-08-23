/**
 * 
 */
package com.javateam.memberex.test;

import com.javateam.memberex.dao.MemberexDAO;
import com.javateam.memberex.dao.MemberexDAOImpl;

/**
 * @author a
 *
 */
public class GetMemberTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		MemberexDAO dao = MemberexDAOImpl.getInstance1();
		
		System.out.println(dao.getMember("jsp1234"));

		
	}

}
