package com.fwx.domain;

public class Member {

	private String id;

	private String discountId;

	private String cardNumber;

	private String username;

	private Integer sex;

	private Integer age;

	private String memberLevel;

	private String phone;

	private Integer cardMoney;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCardMoney() {
		return cardMoney;
	}

	public void setCardMoney(Integer cardMoney) {
		this.cardMoney = cardMoney;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", discountId=" + discountId + ", cardNumber=" + cardNumber + ", username="
				+ username + ", sex=" + sex + ", age=" + age + ", memberLevel=" + memberLevel + ", phone=" + phone
				+ ", cardMoney=" + cardMoney + "]";
	}



}
