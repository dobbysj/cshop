package com.javalec.ex.Ndto;

import java.sql.Timestamp;

public class Ndto {

	public Ndto() {}
	public Ndto(int nrnum, int nid, String ntitle, String ncontent, String nattch, Timestamp ndate, int nhit) {
		this.nrnum = nrnum;
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nattch = nattch;
		this.ndate = ndate;
		this.nhit = nhit;
	}
	
	String ntitle, ncontent, nattch;
	int nid, nhit, nrnum;
	Timestamp ndate;
	
	
	public int getNrnum() {
		return nrnum;
	}
	public void setNrnum(int nrnum) {
		this.nrnum = nrnum;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNattch() {
		return nattch;
	}
	public void setNattch(String nattch) {
		this.nattch = nattch;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNhit() {
		return nhit;
	}
	public void setNhit(int nhit) {
		this.nhit = nhit;
	}
	public Timestamp getNdate() {
		return ndate;
	}
	public void setNdate(Timestamp ndate) {
		this.ndate = ndate;
	}
	
	
	
}
