package chapter06;

public class TeamGroup {
	
	private TeamMember_05[] member = new TeamMember_05[5];
	
	
	public void init() {
		member[0] = new TeamMember_05("신희우", "남학생");
		member[1] = new TeamMember_05("최대호", "남학생");
		member[2] = new TeamMember_05("박현규", "남학생");
		member[3] = new TeamMember_05("유세영", "여학생");
		member[4] = new TeamMember_05("윤준영", "남학생");
		
		
		
	}//init
	public void Disp() {
		for(int i = 0; i< member.length; i++) {
			System.out.println("성명: " + (member[i].getName()) + " 성별: " + member[i].getGender());
		}
	}//disp


}//class
