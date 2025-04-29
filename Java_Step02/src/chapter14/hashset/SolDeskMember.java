package chapter14.hashset;

public class SolDeskMember {
	private int memberId;
	private String memberName;
	
	public SolDeskMember(){
		
	}
	public SolDeskMember(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	// 물리적 주소 
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}
	// 논리적 주소 
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof SolDeskMember) {
			SolDeskMember member = (SolDeskMember)obj;
			return this.memberId == member.memberId || this.memberName.equals(member.memberName);
		}
		return false;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return memberName + " 회원님의 아이디는 " + memberId + "입니다. ";
	}

	
	
}
