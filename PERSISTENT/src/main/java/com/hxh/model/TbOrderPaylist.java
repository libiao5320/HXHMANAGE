/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbOrderPaylist extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbOrderPaylist";
	public static final String ALIAS_PAY_ID = "流水ID";
	public static final String ALIAS_ORDER_ID = "订单ID";
	public static final String ALIAS_PAY_TYPE = "支付类型";
	public static final String ALIAS_PAY_PRICE = "金额";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer payId;

	private Integer orderId;

	private Integer payType;

	private Double payPrice;
	//columns END

	public TbOrderPaylist(){
	}

	public TbOrderPaylist(
		Integer payId
	){
		this.payId = payId;
	}

	public void setPayId(Integer value) {
		this.payId = value;
	}

	public Integer getPayId() {
		return this.payId;
	}
	public void setOrderId(Integer value) {
		this.orderId = value;
	}

	public Integer getOrderId() {
		return this.orderId;
	}
	public void setPayType(Integer value) {
		this.payType = value;
	}

	public Integer getPayType() {
		return this.payType;
	}
	public void setPayPrice(Double value) {
		this.payPrice = value;
	}

	public Double getPayPrice() {
		return this.payPrice;
	}

	
}

