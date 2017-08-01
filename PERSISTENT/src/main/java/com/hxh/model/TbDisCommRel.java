/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;




public class TbDisCommRel extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbDisCommRel";
	public static final String ALIAS_ID = "小区ID";
	public static final String ALIAS_COMM_ID = "小区ID";
	public static final String ALIAS_DIS_ID = "配送人员ID";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

/*	private Integer id;*/

	private Integer commId;
	
	private Integer disId;
	//columns END

	public TbDisCommRel(){
	}


/*	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/

	public void setCommId(Integer value) {
		this.commId = value;
	}
	
	public Integer getCommId() {
		return this.commId;
	}
	public void setDisId(Integer value) {
		this.disId = value;
	}
	
	public Integer getDisId() {
		return this.disId;
	}

	
}

