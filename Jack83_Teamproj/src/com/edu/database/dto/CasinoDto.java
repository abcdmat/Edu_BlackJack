package com.edu.database.dto;

//DATA Transfor Object
public class CasinoDto {
	private int SEQ;
	private String ID;
	private String PASSWORD;
	private String NAME;
	private int MONEY;
	private String FIRST_VISIT;
	private String RECENT_VISIT;
	private String JOB;
	public CasinoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CasinoDto(int sEQ, String iD, String pASSWORD, String nAME, int mONEY, String fIRST_VISIT,
			String rECENT_VISIT, String jOB) {
		super();
		SEQ = sEQ;
		ID = iD;
		PASSWORD = pASSWORD;
		NAME = nAME;
		MONEY = mONEY;
		FIRST_VISIT = fIRST_VISIT;
		RECENT_VISIT = rECENT_VISIT;
		JOB = jOB;
	}
	@Override
	public String toString() {
		return "CasinoDto [SEQ=" + SEQ + ", ID=" + ID + ", PASSWORD=" + PASSWORD + ", NAME=" + NAME + ", MONEY=" + MONEY
				+ ", FIRST_VISIT=" + FIRST_VISIT + ", RECENT_VISIT=" + RECENT_VISIT + ", JOB=" + JOB + "]";
	}
	public int getSEQ() {
		return SEQ;
	}
	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getMONEY() {
		return MONEY;
	}
	public void setMONEY(int mONEY) {
		MONEY = mONEY;
	}
	public String getFIRST_VISIT() {
		return FIRST_VISIT;
	}
	public void setFIRST_VISIT(String fIRST_VISIT) {
		FIRST_VISIT = fIRST_VISIT;
	}
	public String getRECENT_VISIT() {
		return RECENT_VISIT;
	}
	public void setRECENT_VISIT(String rECENT_VISIT) {
		RECENT_VISIT = rECENT_VISIT;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
 
	
	
	
}
