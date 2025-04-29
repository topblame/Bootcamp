package chapter06;

public class TeamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamGroup t = new TeamGroup();
		t.init();
		t.Disp();
		//--------
		TeamMember_05 team = new TeamMember_05();
		
		team.setName("최대호");
		System.out.println("이름 : " + team.getName() );
		team.setmPhone("010-2956-0577");
		System.out.println("휴대폰 번호 : " + team.getmPhone());
		team.setGender("남");
		System.out.println("성별 : " + team.getGender() );
	}

}
