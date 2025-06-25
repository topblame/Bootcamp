package chapter10.Multiinterface;

public class LeastJob implements Scheduler{

	@Override
	public void getNextCall() {
		// TODO Auto-generated method stub
		System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다.");
	}

	@Override
	public void sendCallToAgent() {
		// TODO Auto-generated method stub
		System.out.println("현재 상담 업무가 없거나 상담 대기 시간이 가장 적은 직원에게 배분합니다.");
	}
	
}
