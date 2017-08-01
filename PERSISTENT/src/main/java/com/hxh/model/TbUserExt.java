/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbUserExt extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbUserExt";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_USER_MAIL = "用户邮箱";
	public static final String ALIAS_USER_BIRDAY = "用户生日";
	public static final String ALIAS_USER_NUMBER = "会员账号";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer userId;

	private String userMail;

	private String userBirday;

	private String userNumber;
	//columns END

	public TbUserExt(){
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserMail(String value) {
		this.userMail = value;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setUserBirday(String value) {
		this.userBirday = value;
	}

	public String getUserBirday() {
		return this.userBirday;
	}

	public void setUserNumber(String value) {
		this.userNumber = value;
	}

	public String getUserNumber() {
		return this.userNumber;
	}
	
}

