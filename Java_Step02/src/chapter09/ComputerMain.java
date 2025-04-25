package chapter09;

import chapter08.Desktop;

public class ComputerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Computer c1 = new Computer(); // 추상클래스는 객체를 만들수 없다.
//		Computer c2 = new NoteBook();
		
		Computer c3 = new Desktop();
		Computer c4 = new MyNoteBook();
		
		c3.typing(); // desktop
		c3.display();//desktop 
		c4.display(); // notebook
		c4.typing();//mynotebook
 	}

}
