package com.javalec.ex.EDto;

import java.sql.Timestamp;

public class Edto {

	public Edto() {}
	public Edto(int eId, String eTitle, String eContent, String eImg_thumb, String eImg_cont, String eDate1, String eDate2) {
		this.eId=eId;
		this.eTitle=eTitle;
		this.eContent=eContent;
		this.eImg_thumb=eImg_thumb;
		this.eImg_cont=eImg_cont;
		this.eDate1=eDate1;
		this.eDate2=eDate2;
	}
	
	public int eId, echeck, rnum;
	public String eTitle, eContent, eImg_thumb, eImg_cont;
	public String eDate1, eDate2;

	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	
	public int getEcheck() {
		return echeck;
	}
	public void setEcheck(int echeck) {
		this.echeck = echeck;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteContent() {
		return eContent;
	}
	public void seteContent(String eContent) {
		this.eContent = eContent;
	}
	public String geteImg_thumb() {
		return eImg_thumb;
	}
	public void seteImg_thumb(String eImg_thumb) {
		this.eImg_thumb = eImg_thumb;
	}
	public String geteImg_cont() {
		return eImg_cont;
	}
	public void seteImg_cont(String eImg_cont) {
		this.eImg_cont = eImg_cont;
	}
	public String geteDate1() {
		return eDate1;
	}
	public void seteDate1(String eDate1) {
		this.eDate1 = eDate1;
	}
	public String geteDate2() {
		return eDate2;
	}
	public void seteDate2(String eDate2) {
		this.eDate2 = eDate2;
	}
}
