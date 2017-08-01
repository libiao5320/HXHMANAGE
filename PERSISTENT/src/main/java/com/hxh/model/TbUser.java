

package com.hxh.model;



public class TbUser extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbUser";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_USER_NAME = "用户姓名";
	public static final String ALIAS_USER_SEX = "用户性别";
	public static final String ALIAS_USER_PHONE = "用户手机";
	public static final String ALIAS_USER_WX = "用户微信号";
	public static final String ALIAS_USER_STATE = "用户状态";
	public static final String ALIAS_USER_REGDATE = "用户注册日期";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer userId;

	private String userName;

	private Integer userSex;

	private String userPhone;

	private String userWx;

	private Integer userState;

	private String userRegdate;
	//columns END

	public TbUser(){
	}

	public TbUser(
			Integer userId
	){
		this.userId = userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserName(String value) {
		this.userName = value;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserSex(Integer value) {
		this.userSex = value;
	}

	public Integer getUserSex() {
		return this.userSex;
	}
	public void setUserPhone(String value) {
		this.userPhone = value;
	}

	public String getUserPhone() {
		return this.userPhone;
	}
	public void setUserWx(String value) {
		this.userWx = value;
	}

	public String getUserWx() {
		return this.userWx;
	}
	public void setUserState(Integer value) {
		this.userState = value;
	}

	public Integer getUserState() {
		return this.userState;
	}
	public void setUserRegdate(String value) {
		this.userRegdate = value;
	}

	public String getUserRegdate() {
		return this.userRegdate;
	}

	
}

