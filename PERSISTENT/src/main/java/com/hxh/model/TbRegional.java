/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;


public class TbRegional extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbRegional";
	public static final String ALIAS_REGIONAL_ID = "地域ID";
	public static final String ALIAS_REGIONAL_TYPE = "地域类型";
	public static final String ALIAS_REGIONAL_NAME = "地域名称";
	public static final String ALIAS_REGIONAL_PARENT = "父级地域";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer regionalId;
	
	private Integer regionalType;

	private String regionalName;
	
	private Integer regionalParent;
	//columns END

	public TbRegional(){
	}

	public TbRegional(
		Integer regionalId
	){
		this.regionalId = regionalId;
	}

	public void setRegionalId(Integer value) {
		this.regionalId = value;
	}
	
	public Integer getRegionalId() {
		return this.regionalId;
	}
	public void setRegionalType(Integer value) {
		this.regionalType = value;
	}
	
	public Integer getRegionalType() {
		return this.regionalType;
	}
	public void setRegionalName(String value) {
		this.regionalName = value;
	}
	
	public String getRegionalName() {
		return this.regionalName;
	}
	public void setRegionalParent(Integer value) {
		this.regionalParent = value;
	}
	
	public Integer getRegionalParent() {
		return this.regionalParent;
	}

	
}

