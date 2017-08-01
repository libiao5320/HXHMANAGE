/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;




public class TbUserAccount extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbUserAccount";
	public static final String ALIAS_ACCOUNT_ID = "账户ID";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_ACCOUNT_BAL = "账户余额";
	public static final String ALIAS_ACCOUNT_STATUS = "账户状态";
	public static final String ALIAS_ACCOUNT_PWD = "账户支付密码";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer accountId;

	private Integer userId;

	private Double accountBal;

	private Integer accountStatus;

	private String accountPwd;
	//columns END

	public TbUserAccount(){
	}

	public TbUserAccount(
		Integer accountId
	){
		this.accountId = accountId;
	}

	public void setAccountId(Integer value) {
		this.accountId = value;
	}

	public Integer getAccountId() {
		return this.accountId;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setAccountBal(Double value) {
		this.accountBal = value;
	}

	public Double getAccountBal() {
		return this.accountBal;
	}
	public void setAccountStatus(Integer value) {
		this.accountStatus = value;
	}

	public Integer getAccountStatus() {
		return this.accountStatus;
	}
	public void setAccountPwd(String value) {
		this.accountPwd = value;
	}

	public String getAccountPwd() {
		return this.accountPwd;
	}

	
}

