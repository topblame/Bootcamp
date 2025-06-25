package chapter06;

import javax.swing.JOptionPane;

public class SungJuk {

	//멤버변수 = 필드 = 속성
	private String std_num; //읽기전용 
	private String std_name;
	private int java, oracle, spring;

	public SungJuk() {
		// TODO Auto-generated constructor stub
	}
	// 메서드
	public void Sum() {
		int sum = java + oracle + spring;
		System.out.println("총합 " + sum);
	}
	public void Avg() {
		double avg = (double)(java + oracle + spring)/ 3;
		System.out.println("평균 : " + avg);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SungJuk rec = new SungJuk();
		rec.std_num = JOptionPane.showInputDialog("학번");
		rec.std_name = JOptionPane.showInputDialog("이름");
		
		rec.java = Integer.parseInt(JOptionPane.showInputDialog("자바점수"));
		rec.oracle = Integer.parseInt(JOptionPane.showInputDialog("오라클점수"));
		rec.spring = Integer.parseInt(JOptionPane.showInputDialog("스프링점수"));
		
		System.out.println("학번 " + rec.std_num + " | " + "성명" + rec.std_name);
		rec.Sum();
		rec.Avg();
	}

}
