/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbOrder extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbOrder";
	public static final String ALIAS_ORDER_ID = "订单ID";
	public static final String ALIAS_ORDER_SEQ = "订单编号";
	public static final String ALIAS_COMM_ID = "小区ID";
	public static final String ALIAS_CHK_ID = "核查人员ID";
	public static final String ALIAS_SERVICE_ID = "客服ID";
	public static final String ALIAS_BOX_ID = "箱子ID";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_DIS_ID = "配送人员ID";
	public static final String ALIAS_ORDER_DATE = "订单生成日期";
	public static final String ALIAS_ORDER_PRICE = "订单金额";
	public static final String ALIAS_ORDER_PHONE = "用户手机";
	public static final String ALIAS_ORDER_PAYTYPE = "支付方式";
	public static final String ALIAS_ORDER_TYPE = "订单下单类型：微信下单1，电话下单2";
	public static final String ALIAS_ORDER_MODEL = "订单模式：投放箱子1，上门取件2";
	public static final String ALIAS_ORDER_STATUS = "当前状态";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer orderId;

	private String orderSeq;

	private Integer commId;

	private Integer chkId;

	private Integer serviceId;

	private Integer boxId;

	private Integer userId;

	private Integer disId;

	private String orderDate;

	private Double orderPrice;

	private String orderPhone;

	private Integer orderPaytype;

	private Integer orderType;

	private Integer orderModel;

	private Integer orderStatus;
	//columns END

	public TbOrder(){
	}

	public TbOrder(
		Integer orderId
	){
		this.orderId = orderId;
	}

	public void setOrderId(Integer value) {
		this.orderId = value;
	}

	public Integer getOrderId() {
		return this.orderId;
	}
	public void setOrderSeq(String value) {
		this.orderSeq = value;
	}

	public String getOrderSeq() {
		return this.orderSeq;
	}
	public void setCommId(Integer value) {
		this.commId = value;
	}

	public Integer getCommId() {
		return this.commId;
	}
	public void setChkId(Integer value) {
		this.chkId = value;
	}

	public Integer getChkId() {
		return this.chkId;
	}
	public void setServiceId(Integer value) {
		this.serviceId = value;
	}

	public Integer getServiceId() {
		return this.serviceId;
	}
	public void setBoxId(Integer value) {
		this.boxId = value;
	}

	public Integer getBoxId() {
		return this.boxId;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setDisId(Integer value) {
		this.disId = value;
	}

	public Integer getDisId() {
		return this.disId;
	}
	public void setOrderDate(String value) {
		this.orderDate = value;
	}

	public String getOrderDate() {
		return this.orderDate;
	}
	public void setOrderPrice(Double value) {
		this.orderPrice = value;
	}

	public Double getOrderPrice() {
		return this.orderPrice;
	}
	public void setOrderPhone(String value) {
		this.orderPhone = value;
	}

	public String getOrderPhone() {
		return this.orderPhone;
	}
	public void setOrderPaytype(Integer value) {
		this.orderPaytype = value;
	}

	public Integer getOrderPaytype() {
		return this.orderPaytype;
	}
	public void setOrderType(Integer value) {
		this.orderType = value;
	}

	public Integer getOrderType() {
		return this.orderType;
	}
	public void setOrderModel(Integer value) {
		this.orderModel = value;
	}

	public Integer getOrderModel() {
		return this.orderModel;
	}
	public void setOrderStatus(Integer value) {
		this.orderStatus = value;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	
}

