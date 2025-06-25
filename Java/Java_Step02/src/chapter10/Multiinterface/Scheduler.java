package chapter10.Multiinterface;

public interface Scheduler {
	// 다른 고객의 콜 가져오기
	public void getNextCall();
	
	// 상담원에게 콜전달
	public void sendCallToAgent();
}
