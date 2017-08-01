/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;


public class TbCommunity extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbCommunity";
	public static final String ALIAS_COMM_ID = "小区ID";
	public static final String ALIAS_REGIONAL_ID = "地域ID";
	public static final String ALIAS_COMM_NAME = "小区名称";
	public static final String ALIAS_COMM_DESC = "小区地址描述";
	public static final String ALIAS_COMM_LATITUDE = "小区纬度";
	public static final String ALIAS_COMM_LONGITUD = "小区经度";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer commId;
	
	private Integer regionalId;

	private String commName;

	private String commDesc;

	private Double commLatitude;

	private Double commLongitud;
	//columns END

	public TbCommunity(){
	}

	public TbCommunity(
		Integer commId
	){
		this.commId = commId;
	}

	public void setCommId(Integer value) {
		this.commId = value;
	}
	
	public Integer getCommId() {
		return this.commId;
	}
	public void setRegionalId(Integer value) {
		this.regionalId = value;
	}
	
	public Integer getRegionalId() {
		return this.regionalId;
	}
	public void setCommName(String value) {
		this.commName = value;
	}
	
	public String getCommName() {
		return this.commName;
	}
	public void setCommDesc(String value) {
		this.commDesc = value;
	}
	
	public String getCommDesc() {
		return this.commDesc;
	}

	public void setCommLatitude(Double value) {
		this.commLatitude = value;
	}

	public Double getCommLatitude() {
		return this.commLatitude;
	}

	public void setCommLongitud(Double value) {
		this.commLongitud = value;
	}

	public Double getCommLongitud() {
		return this.commLongitud;
	}
}

