/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbDiser extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbDiser";
	public static final String ALIAS_DIS_ID = "配送人员ID";
	public static final String ALIAS_DIS_WORKNUM = "配送人员工号";
	public static final String ALIAS_DIS_NAME = "配送人员姓名";
	public static final String ALIAS_DIS_USERNAME = "配送人员登陆账号";
	public static final String ALIAS_DIS_PWD = "配送人员登陆密码";
	public static final String ALIAS_DIS_WX = "配送人员微信号";
	public static final String ALIAS_DIS_PHONE = "配送人员手机号";
	public static final String ALIAS_DIS_STATUS = "配送人员状态";
	public static final String ALIAS_DIS_PHOTO = "形象照片";
	public static final String ALIAS_DIS_GOOD = "好评数量";
	public static final String ALIAS_DIS_BAD = "差评数量";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer disId;

	private String disWorknum;

	private String disName;

	private String disUsername;

	private String disPwd;

	private String disWx;

	private String disPhone;

	private Integer disStatus;

	private String disPhoto;

	private Integer disGood;

	private Integer disBad;
	//columns END

	public TbDiser(){
	}

	public TbDiser(
			Integer disId
	){
		this.disId = disId;
	}

	public void setDisId(Integer value) {
		this.disId = value;
	}

	public Integer getDisId() {
		return this.disId;
	}
	public void setDisWorknum(String value) {
		this.disWorknum = value;
	}

	public String getDisWorknum() {
		return this.disWorknum;
	}
	public void setDisName(String value) {
		this.disName = value;
	}

	public String getDisName() {
		return this.disName;
	}
	public void setDisUsername(String value) {
		this.disUsername = value;
	}

	public String getDisUsername() {
		return this.disUsername;
	}
	public void setDisPwd(String value) {
		this.disPwd = value;
	}

	public String getDisPwd() {
		return this.disPwd;
	}
	public void setDisWx(String value) {
		this.disWx = value;
	}

	public String getDisWx() {
		return this.disWx;
	}
	public void setDisPhone(String value) {
		this.disPhone = value;
	}

	public String getDisPhone() {
		return this.disPhone;
	}
	public void setDisStatus(Integer value) {
		this.disStatus = value;
	}

	public Integer getDisStatus() {
		return this.disStatus;
	}
	public void setDisPhoto(String value) {
		this.disPhoto = value;
	}

	public String getDisPhoto() {
		return this.disPhoto;
	}
	public void setDisGood(Integer value) {
		this.disGood = value;
	}

	public Integer getDisGood() {
		return this.disGood;
	}
	public void setDisBad(Integer value) {
		this.disBad = value;
	}

	public Integer getDisBad() {
		return this.disBad;
	}

	
}

