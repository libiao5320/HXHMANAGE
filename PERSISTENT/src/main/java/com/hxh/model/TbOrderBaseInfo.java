/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;


public class TbOrderBaseInfo extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbOrderBaseInfo";
	public static final String ALIAS_BASEINFO_ID = "基础信息ID";
	public static final String ALIAS_ORDER_ID = "订单ID";
	public static final String ALIAS_BASEINFO_DESC = "订单描述";
	public static final String ALIAS_BASEINFO_SENDADD = "送货地址描述";
	public static final String ALIAS_BASEINFO_DELIADD = "收货地址描述";
	public static final String ALIAS_ORDER_EVAL = "总体服务评价：1,：赞，2：不好";
	public static final String ALIAS_ORDER_COMMENT = "总体服务点评";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer baseinfoId;

	private Integer orderId;

	private String baseinfoDesc;

	private String baseinfoSendadd;

	private String baseinfoDeliadd;

	private Integer orderEval;

	private String orderComment;

	private String orderVoicePath;
	//columns END

	public TbOrderBaseInfo(){
	}

	public TbOrderBaseInfo(
		Integer baseinfoId
	){
		this.baseinfoId = baseinfoId;
	}

	public void setBaseinfoId(Integer value) {
		this.baseinfoId = value;
	}

	public Integer getBaseinfoId() {
		return this.baseinfoId;
	}
	public void setOrderId(Integer value) {
		this.orderId = value;
	}

	public Integer getOrderId() {
		return this.orderId;
	}
	public void setBaseinfoDesc(String value) {
		this.baseinfoDesc = value;
	}

	public String getBaseinfoDesc() {
		return this.baseinfoDesc;
	}
	public void setBaseinfoSendadd(String value) {
		this.baseinfoSendadd = value;
	}

	public String getBaseinfoSendadd() {
		return this.baseinfoSendadd;
	}
	public void setBaseinfoDeliadd(String value) {
		this.baseinfoDeliadd = value;
	}

	public String getBaseinfoDeliadd() {
		return this.baseinfoDeliadd;
	}
	public void setOrderEval(Integer value) {
		this.orderEval = value;
	}

	public Integer getOrderEval() {
		return this.orderEval;
	}
	public void setOrderComment(String value) {
		this.orderComment = value;
	}

	public String getOrderComment() {
		return this.orderComment;
	}

	public String getOrderVoicePath() {
		return orderVoicePath;
	}

	public void setOrderVoicePath(String orderVoicePath) {
		this.orderVoicePath = orderVoicePath;
	}
}

