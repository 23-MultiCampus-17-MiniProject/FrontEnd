package spring.tv;

public class SamsungTV implements TV{
	
	public void powerOn() {
		System.out.println("삼성티비 전원on");
	}
	public void powerOff() {
		System.out.println("삼성티비 전원off");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("삼성티비 볼륨up");
		
	}
	@Override
	public void volumeDown() {
		
		System.out.println("삼성티비 볼륨down");
	}
	
}
