package java.com.thejoa703.dto;

public class mbtiDto {

	 private int MBTI_TYPE_ID;
	 private String NAME;
	 private String DESCRIPTION;
	 public mbtiDto() {
		super();
		// TODO Auto-generated constructor stub
	 }
	 public mbtiDto(int mBTI_TYPE_ID, String nAME, String dESCRIPTION) {
		super();
		MBTI_TYPE_ID = mBTI_TYPE_ID;
		NAME = nAME;
		DESCRIPTION = dESCRIPTION;
	 }
	 @Override
	 public String toString() {
		return "mbtiDto [MBTI_TYPE_ID=" + MBTI_TYPE_ID + ", NAME=" + NAME + ", DESCRIPTION=" + DESCRIPTION + "]";
	 }
	 public int getMBTI_TYPE_ID() {
		 return MBTI_TYPE_ID;
	 }
	 public void setMBTI_TYPE_ID(int mBTI_TYPE_ID) {
		 MBTI_TYPE_ID = mBTI_TYPE_ID;
	 }
	 public String getNAME() {
		 return NAME;
	 }
	 public void setNAME(String nAME) {
		 NAME = nAME;
	 }
	 public String getDESCRIPTION() {
		 return DESCRIPTION;
	 }
	 public void setDESCRIPTION(String dESCRIPTION) {
		 DESCRIPTION = dESCRIPTION;
	 }
	 
	 
}
