/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;




public class TbOrderStatus extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbOrderStatus";
	public static final String ALIAS_ORDER_ID = "订单ID";
	public static final String ALIAS_STATUS_ID = "状态ID";
	public static final String ALIAS_ORDER_DESC = "描述";
	public static final String ALIAS_STATUS_TIME = "时间";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	private Integer id;

	private Integer orderId;

	private Integer statusId;

	private String orderDesc;

	private String statusTime;
	//columns END

	public TbOrderStatus(){
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrderId(Integer value) {
		this.orderId = value;
	}

	public Integer getOrderId() {
		return this.orderId;
	}
	public void setStatusId(Integer value) {
		this.statusId = value;
	}

	public Integer getStatusId() {
		return this.statusId;
	}
	public void setOrderDesc(String value) {
		this.orderDesc = value;
	}

	public String getOrderDesc() {
		return this.orderDesc;
	}
	public void setStatusTime(String value) {
		this.statusTime = value;
	}

	public String getStatusTime() {
		return this.statusTime;
	}

	
}

