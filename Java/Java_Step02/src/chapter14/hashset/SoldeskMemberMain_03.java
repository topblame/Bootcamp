package chapter14.hashset;

public class SoldeskMemberMain_03 {
	public static void main(String[] args) {
		SolDeskMemberManager manager = new SolDeskMemberManager();
		
		SolDeskMember member1 = new SolDeskMember(1001, "홍길동");
		SolDeskMember member2 = new SolDeskMember(1002, "홍준표");
		SolDeskMember member3 = new SolDeskMember(1003, "김신우");
		SolDeskMember member4 = new SolDeskMember(1004, "김진수");
		
		manager.addMember(member1);
		manager.addMember(member2);
		manager.addMember(member3);
		manager.addMember(member4);
		System.out.println();
		
		manager.showAllMember();
		
		SolDeskMember duplicateMember = new SolDeskMember (1003, "김신우");
		manager.addMember(duplicateMember);
		
		System.out.println("==========전체회원==========");
		manager.showAllMember();
	}
}
