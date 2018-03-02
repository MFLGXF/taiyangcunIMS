package com.cr.vo;

import java.io.Serializable;

public class UserCountVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int newBorn;
	private int death;
	private int live;
	private int stay;
	private String bornPro;
	private String deathPro;
	private String livePro;
	private String stayPro;
	
	public String getBornPro() {
		return bornPro;
	}
	public void setBornPro(String bornPro) {
		this.bornPro = bornPro;
	}
	public String getDeathPro() {
		return deathPro;
	}
	public void setDeathPro(String deathPro) {
		this.deathPro = deathPro;
	}
	public String getLivePro() {
		return livePro;
	}
	public void setLivePro(String livePro) {
		this.livePro = livePro;
	}
	public String getStayPro() {
		return stayPro;
	}
	public void setStayPro(String stayPro) {
		this.stayPro = stayPro;
	}
	public int getNewBorn() {
		return newBorn;
	}
	public void setNewBorn(int newBorn) {
		this.newBorn = newBorn;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public int getLive() {
		return live;
	}
	public void setLive(int live) {
		this.live = live;
	}
	public int getStay() {
		return stay;
	}
	public void setStay(int stay) {
		this.stay = stay;
	}
}
