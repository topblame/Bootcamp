package chapter18.stream;

public class Student {
	private int num;
	private String name;
	private int eng;
	
	public Student(int num, String name, int eng) {
		this.num = num;
		this.name = name;
		this.eng = eng;
	}

	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", eng=" + eng + "]";
	}
	
	
}
