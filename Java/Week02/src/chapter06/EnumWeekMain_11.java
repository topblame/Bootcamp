package chapter06;

import java.util.Calendar;

public class EnumWeekMain_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Week today = null;
		Calendar cal = Calendar.getInstance();
		int week = (cal.get(Calendar.DAY_OF_WEEK));
		
		switch(week) {
			case 1:{
				today = Week.SUNDAY;
				break;
			}
			case 2:{
				today = Week.MONDAY;
				break;
			}
				
			case 3:{
				today = Week.TUESDAY;
				break;
			}
			case 4:{
				today = Week.WEDNESDAY;
				break;
			}
			case 5:{
				today = Week.THURSDAY;
				break;
			}
			case 6:{
				today = Week.FRIDAY;
				break;
			}
			case 7:{
				today = Week.SATURDAY;
				break;
			}

		}//switch
		System.out.println("오늘의 요일: today");
		
		if(today == Week.SATURDAY) {
			System.out.println("영화보기");
		}
		else {
			System.out.println("출근하기.");
		}
	}

}
