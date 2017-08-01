/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbUserAddress extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbUserAddress";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_COMM_ID = "小区ID";
	public static final String ALIAS_COMM_DETAIL_ID = "详细地址ID";
	public static final String ALIAS_ADDRESS_ID = "ID";
	public static final String ALIAS_ADDRESS_TYPE = "类型";
	public static final String ALIAS_ADDRESS_DESC = "详细描述";
	public static final String ALIAS_ADDRESS_STATUS = "状态：1:默认，0:非默认";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer userId;

	private Integer commId;

	private Integer commDetailId;

	private Integer addressId;

	private Integer addressType;

	private String addressDesc;

	private Integer addressStatus;

	private String addressDate;



	//columns END

	public TbUserAddress(){
	}



	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setCommId(Integer value) {
		this.commId = value;
	}

	public Integer getCommId() {
		return this.commId;
	}
	public void setCommDetailId(Integer value) {
		this.commDetailId = value;
	}

	public Integer getCommDetailId() {
		return this.commDetailId;
	}
	public void setAddressId(Integer value) {
		this.addressId = value;
	}

	public Integer getAddressId() {
		return this.addressId;
	}
	public void setAddressType(Integer value) {
		this.addressType = value;
	}

	public Integer getAddressType() {
		return this.addressType;
	}
	public void setAddressDesc(String value) {
		this.addressDesc = value;
	}

	public String getAddressDesc() {
		return this.addressDesc;
	}
	public void setAddressStatus(Integer value) {
		this.addressStatus = value;
	}

	public Integer getAddressStatus() {
		return this.addressStatus;
	}

	public String getAddressDate() {
		return addressDate;
	}

	public void setAddressDate(String addressDate) {
		this.addressDate = addressDate;
	}
}

