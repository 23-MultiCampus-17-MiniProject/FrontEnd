package tv;

public class LGTV implements TV{

	public void volumeUp() {
		System.out.println("lgtv 볼륨up");
	}
	public void volumeDown() {
		System.out.println("lgtv 볼륨down");
	}
	@Override
	public void powerOn() {
		System.out.println("lgtv 전원on");
		
	}
	@Override
	public void powerOff() {
		System.out.println("lgtv 전원off");
		
	}
}
