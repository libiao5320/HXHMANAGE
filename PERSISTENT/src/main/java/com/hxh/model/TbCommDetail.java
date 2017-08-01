/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class TbCommDetail extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbCommDetail";
	public static final String ALIAS_COMM_ID = "小区ID";
	public static final String ALIAS_COMM_DETAIL_ID = "详细地址ID";
	public static final String ALIAS_COMM_DESC = "地址描述";
	public static final String ALIAS_COMM_STATUS = "状态";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer commId;
	
	private Integer commDetailId;

	private String commDesc;
	
	private Integer commStatus;
	//columns END

	public TbCommDetail(){
	}

	public TbCommDetail(
		Integer commDetailId
	){
		this.commDetailId = commDetailId;
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
	public void setCommDesc(String value) {
		this.commDesc = value;
	}
	
	public String getCommDesc() {
		return this.commDesc;
	}
	public void setCommStatus(Integer value) {
		this.commStatus = value;
	}
	
	public Integer getCommStatus() {
		return this.commStatus;
	}

	
}

