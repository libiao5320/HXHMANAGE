/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbCoupon extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbCoupon";
	public static final String ALIAS_COUPON_ID = "优惠券ID";
	public static final String ALIAS_COUPON_NAME = "优惠券名称";
	public static final String ALIAS_COUPON_STATUS = "优惠券状态";
	public static final String ALIAS_COUPON_START = "优惠券生效日期";
	public static final String ALIAS_COUPON_END = "优惠券截止日期";
	public static final String ALIAS_COUPON_CREATE = "优惠券创建日期";
	public static final String ALIAS_COUPON_PRICE = "优惠券金额";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer couponId;

	private String couponName;
	
	private Integer couponStatus;

	private String couponStart;

	private String couponEnd;

	private String couponCreate;
	
	private Double couponPrice;
	//columns END

	public TbCoupon(){
	}

	public TbCoupon(
		Integer couponId
	){
		this.couponId = couponId;
	}

	public void setCouponId(Integer value) {
		this.couponId = value;
	}
	
	public Integer getCouponId() {
		return this.couponId;
	}
	public void setCouponName(String value) {
		this.couponName = value;
	}
	
	public String getCouponName() {
		return this.couponName;
	}
	public void setCouponStatus(Integer value) {
		this.couponStatus = value;
	}
	
	public Integer getCouponStatus() {
		return this.couponStatus;
	}
	public void setCouponStart(String value) {
		this.couponStart = value;
	}
	
	public String getCouponStart() {
		return this.couponStart;
	}
	public void setCouponEnd(String value) {
		this.couponEnd = value;
	}
	
	public String getCouponEnd() {
		return this.couponEnd;
	}
	public void setCouponCreate(String value) {
		this.couponCreate = value;
	}
	
	public String getCouponCreate() {
		return this.couponCreate;
	}
	public void setCouponPrice(Double value) {
		this.couponPrice = value;
	}
	
	public Double getCouponPrice() {
		return this.couponPrice;
	}

	
}

