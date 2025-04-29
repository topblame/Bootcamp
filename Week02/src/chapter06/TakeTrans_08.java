package chapter06;

public class TakeTrans_08 {
	public static void main(String[] args) {
		StdInfo studentJames = new StdInfo("James", 20000);
		StdInfo studentTom = new StdInfo("Tom", 23000);

		
		Bus bus100 = new Bus(100);
		studentJames.takeBus(bus100);
		studentJames.showInfo();
		bus100.showInfo();
		
		System.out.println("-----------");
		Subway subwayGreen =  new Subway("2호선");
		studentTom.takeSubway(subwayGreen);
		studentTom.showInfo();
		bus100.showInfo();
		
		//
		System.out.println("----------");
		Subway subwayOrange = new Subway("3호선");
		studentTom.takeSubway(subwayOrange);
		
		studentTom.showInfo();
		studentJames.showInfo();
	}
}
