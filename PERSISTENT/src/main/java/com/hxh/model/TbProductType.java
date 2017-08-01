/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbProductType extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbProductType";
	public static final String ALIAS_TYPE_ID = "类别ID";
	public static final String ALIAS_TYPE_NAME = "类别名称";
	public static final String ALIAS_TYPE_PARENT = "所属类别";
	public static final String ALIAS_TYPE_STATUS = "状态";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer typeId;

	private String typeName;

	private Integer typeParent;

	private Integer typeStatus;
	//columns END

	public TbProductType(){
	}

	public TbProductType(
		Integer typeId
	){
		this.typeId = typeId;
	}

	public void setTypeId(Integer value) {
		this.typeId = value;
	}

	public Integer getTypeId() {
		return this.typeId;
	}
	public void setTypeName(String value) {
		this.typeName = value;
	}

	public String getTypeName() {
		return this.typeName;
	}
	public void setTypeParent(Integer value) {
		this.typeParent = value;
	}

	public Integer getTypeParent() {
		return this.typeParent;
	}
	public void setTypeStatus(Integer value) {
		this.typeStatus = value;
	}

	public Integer getTypeStatus() {
		return this.typeStatus;
	}

	
}

