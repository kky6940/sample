package com.ezen.koh10.score0319;

public class ScoreDTO { 
	int id;
	int kor,eng,mat;
	MyinfoDTO myinfo;
	InsaDTO insa;
	public MyinfoDTO getMyinfo() {
		return myinfo;
	}
	public void setMyinfo(MyinfoDTO myinfo) {
		this.myinfo = myinfo;
	}
	
	public InsaDTO getInsa() {
		return insa;
	}
	public void setInsa(InsaDTO insa) {
		this.insa = insa;
	}
	public ScoreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	
}
