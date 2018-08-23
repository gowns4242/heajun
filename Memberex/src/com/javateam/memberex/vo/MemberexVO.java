/**
 * 
 */
package com.javateam.memberex.vo;

//import java.sql.Date;

/**
 * 
 * 회원 정보 테이블 객체
 * @author a
 *
 */
public class MemberexVO {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String email;
	private String mobile;
	private String phone;
	private String zip;
	private String address;
	private String birthday;
	private String joindate;
	/**
	 * @param id
	 * @param pw
	 * @param name
	 * @param gender
	 * @param email
	 * @param mobile
	 * @param phone
	 * @param zip
	 * @param address
	 * @param birthday
	 * @param joindate
	 */
	
	public MemberexVO() {}
	
	public MemberexVO(String id, String pw, String name, String gender, String email, String mobile, String phone,
			String zip, String address, String birthday) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
		this.zip = zip;
		this.address = address;
		this.birthday = birthday;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}
	/**
	 * @param pw the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * @param joindate the joindate to set
	 */
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberexVO [id=");
		builder.append(id);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", email=");
		builder.append(email);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", zip=");
		builder.append(zip);
		builder.append(", address=");
		builder.append(address);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", joindate=");
		builder.append(joindate);
		builder.append("]");
		return builder.toString();
	}

}
