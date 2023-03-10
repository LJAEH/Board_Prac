package prac.jh.member.vo;

public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String enrollDate;
	private String secessionFlag;
	
	public Member() {
		
	}

	public Member(int memberNo, String memberId, String memberPw, String memberName, String memberGender,
			String enrollDate, String secessionFlag) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.enrollDate = enrollDate;
		this.secessionFlag = secessionFlag;
	}
	
	
	

	public Member(String memberId, String memberPw, String memberName, String memberGender) {
		// TODO Auto-generated constructor stub
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
	}

	public Member(int memberNo, String memberId,String memberName,String memberGender,String enrollDate) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.enrollDate = enrollDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getSecessionFlag() {
		return secessionFlag;
	}

	public void setSecessionFlag(String secessionFlag) {
		this.secessionFlag = secessionFlag;
	}

	@Override
	public String toString() {
		return "Member [memberVO=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberGender=" + memberGender + ", enrollDate=" + enrollDate + ", secessionFlag="
				+ secessionFlag + "]";
	}
	
	

}
