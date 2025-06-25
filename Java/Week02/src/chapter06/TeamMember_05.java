package chapter06;

public class TeamMember_05 {
	public String teamName;//팀명
	public String mName; //팀장명
	public String mPhone; // 팀장번호
	public String sName;// 부팀장명
	public String name; // 성명
	public String gender; //성별
	
	//기본생성자
	public TeamMember_05() {
		// TODO Auto-generated constructor stub
	}
	//overload
	public TeamMember_05(String name, String gender) {
		// TODO Auto-generated constructor stub
		this.name = name;
		
		this.gender = gender;
	}
	//getter setter
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
