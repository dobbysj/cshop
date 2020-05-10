package com.javalec.ex.Adto;

public class Adto {

	public Adto() {}
	
	
	public Adto(int anum, int level, String aid, String apw) {
		this.anum = anum;
		this.level = level;
		this.aid = aid;
		this.apw = apw;
	}


	public int anum, level;
	public String aid, apw;
	
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getApw() {
		return apw;
	}
	public void setApw(String apw) {
		this.apw = apw;
	} 
	
}
