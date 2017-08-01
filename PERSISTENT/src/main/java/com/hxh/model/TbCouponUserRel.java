/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.hxh.model;



public class TbCouponUserRel extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbCouponUserRel";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_COUPON_ID = "优惠券ID";
	public static final String ALIAS_STATUS = "状态";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Integer userId;
	
	private Integer couponId;
	
	private Integer status;
	//columns END

	public TbCouponUserRel(){
	}



	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setCouponId(Integer value) {
		this.couponId = value;
	}
	
	public Integer getCouponId() {
		return this.couponId;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}

	
}

