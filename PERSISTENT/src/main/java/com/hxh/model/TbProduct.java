/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;




public class TbProduct extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbProduct";
	public static final String ALIAS_PRO_ID = "产品ID";
	public static final String ALIAS_TYPE_ID = "类别ID";
	public static final String ALIAS_PRO_NAME = "产品名称";
	public static final String ALIAS_PRO_REALPRICE = "产品实际价格";
	public static final String ALIAS_PRO_PRICE = "产品原价";
	public static final String ALIAS_PRO_IMG = "产品图片";
	public static final String ALIAS_PRO_STATUS = "产品状态";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer proId;

	private Integer typeId;

	private String proName;

	private Double proRealprice;

	private Double proPrice;

	private String proImg;

	private Integer proStatus;


	private String proUnit;
	//columns END

	public TbProduct(){
	}

	public TbProduct(
			Integer proId
	){
		this.proId = proId;
	}

	public void setProId(Integer value) {
		this.proId = value;
	}

	public Integer getProId() {
		return this.proId;
	}
	public void setTypeId(Integer value) {
		this.typeId = value;
	}

	public Integer getTypeId() {
		return this.typeId;
	}
	public void setProName(String value) {
		this.proName = value;
	}

	public String getProName() {
		return this.proName;
	}
	public void setProRealprice(Double value) {
		this.proRealprice = value;
	}

	public Double getProRealprice() {
		return this.proRealprice;
	}
	public void setProPrice(Double value) {
		this.proPrice = value;
	}

	public Double getProPrice() {
		return this.proPrice;
	}
	public void setProImg(String value) {
		this.proImg = value;
	}

	public String getProImg() {
		return this.proImg;
	}
	public void setProStatus(Integer value) {
		this.proStatus = value;
	}

	public Integer getProStatus() {
		return this.proStatus;
	}

	public String getProUnit() {
		return proUnit;
	}

	public void setProUnit(String proUnit) {
		this.proUnit = proUnit;
	}
}

