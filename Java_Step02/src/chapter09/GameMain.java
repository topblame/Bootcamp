package chapter09;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("전사전투");
		GameCharacter warrior = new Warrior();
		warrior.fight();

		System.out.println("\n마법사전투");
		GameCharacter wizard = new Wizard();
		wizard.fight();
	}

}
