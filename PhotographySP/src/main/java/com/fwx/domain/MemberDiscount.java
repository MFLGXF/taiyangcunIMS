package com.fwx.domain;
/**
 * 会员卡优惠信息
 * @author mfl
 *
 */
public class MemberDiscount {

	private String id;

	private String cardTypeName;

	private Integer discount;

	/*
	 * 优惠方案描述
	 */
	private String discription;

	/*
	 * 会员卡优惠等级
	 */
	private Integer level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "MemberDiscount [id=" + id + ", cardTypeName=" + cardTypeName + ", discount=" + discount
				+ ", discription=" + discription + ", level=" + level + "]";
	}


}
