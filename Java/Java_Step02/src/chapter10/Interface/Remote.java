package chapter10.Interface;

public interface Remote {
	
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	//추상메소드
	void turnOn();
	void turnOff();
	
	void setVolume(int volume);
}
