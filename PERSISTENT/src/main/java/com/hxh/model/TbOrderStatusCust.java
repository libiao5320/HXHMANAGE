/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;




public class TbOrderStatusCust extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbOrderStatusCust";
	public static final String ALIAS_STATUS_ID = "状态ID";
	public static final String ALIAS_STATUS_NAME = "状态名称";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer statusId;

	private String statusName;
	//columns END

	public TbOrderStatusCust(){
	}

	public TbOrderStatusCust(
		Integer statusId
	){
		this.statusId = statusId;
	}

	public void setStatusId(Integer value) {
		this.statusId = value;
	}

	public Integer getStatusId() {
		return this.statusId;
	}
	public void setStatusName(String value) {
		this.statusName = value;
	}

	public String getStatusName() {
		return this.statusName;
	}

	
}

