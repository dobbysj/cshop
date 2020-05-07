package com.javalec.ex.MDto;

import java.sql.Timestamp;

public class Mdto {

	public Mdto() {}
	public Mdto(String mname, String mid, String mpw, String memail, String memail2, int mzonecode, String maddress1, String maddress2, int mphone1, int mphone2, int mphone3, Timestamp mbirth, String mgender, String mnews, String msms) {
		this.mname=mname;
		this.mid=mid;
		this.mpw=mpw;
		this.memail=memail;
		this.memail2=memail2;
		this.maddress1=maddress1;
		this.maddress2=maddress2;
		this.mgender=mgender;
		this.mnews=mnews;
		this.msms=msms;
		this.mzonecode=mzonecode;
		this.mphone1=mphone1;
		this.mphone2=mphone2;
		this.mphone3=mphone3;
		this.mbirth=mbirth;
	}
	
	String mname,mid,mpw,memail,memail2,maddress1,maddress2,mgender,mnews,msms;
	int mzonecode,mphone1,mphone2,mphone3;
	Timestamp mbirth;
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMemail2() {
		return memail2;
	}
	public void setMemail2(String memail2) {
		this.memail2 = memail2;
	}
	public String getMaddress1() {
		return maddress1;
	}
	public void setMaddress1(String maddress1) {
		this.maddress1 = maddress1;
	}
	public String getMaddress2() {
		return maddress2;
	}
	public void setMaddress2(String maddress2) {
		this.maddress2 = maddress2;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMnews() {
		return mnews;
	}
	public void setMnews(String mnews) {
		this.mnews = mnews;
	}
	public String getMsms() {
		return msms;
	}
	public void setMsms(String msms) {
		this.msms = msms;
	}
	public int getMzonecode() {
		return mzonecode;
	}
	public void setMzonecode(int mzonecode) {
		this.mzonecode = mzonecode;
	}
	public int getMphone1() {
		return mphone1;
	}
	public void setMphone1(int mphone1) {
		this.mphone1 = mphone1;
	}
	public int getMphone2() {
		return mphone2;
	}
	public void setMphone2(int mphone2) {
		this.mphone2 = mphone2;
	}
	public int getMphone3() {
		return mphone3;
	}
	public void setMphone3(int mphone3) {
		this.mphone3 = mphone3;
	}
	public Timestamp getMbirth() {
		return mbirth;
	}
	public void setMbirth(Timestamp mbirth) {
		this.mbirth = mbirth;
	}
	
}
