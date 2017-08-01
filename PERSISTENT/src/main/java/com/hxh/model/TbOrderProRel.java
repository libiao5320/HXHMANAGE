/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbOrderProRel extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbOrderProRel";
	public static final String ALIAS_ORDER_ID = "订单ID";
	public static final String ALIAS_PRO_ID = "产品ID";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_PRICE = "单价金额";
	public static final String ALIAS_COUNT = "数量";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer orderId;

	private Integer proId;

	private Integer id;

	private Double price;

	private Integer count;
	//columns END

	public TbOrderProRel(){
	}


	public void setOrderId(Integer value) {
		this.orderId = value;
	}

	public Integer getOrderId() {
		return this.orderId;
	}
	public void setProId(Integer value) {
		this.proId = value;
	}

	public Integer getProId() {
		return this.proId;
	}
	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}
	public void setPrice(Double value) {
		this.price = value;
	}

	public Double getPrice() {
		return this.price;
	}
	public void setCount(Integer value) {
		this.count = value;
	}

	public Integer getCount() {
		return this.count;
	}

	
}

