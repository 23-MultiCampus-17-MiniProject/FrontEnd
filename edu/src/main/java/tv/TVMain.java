package tv;

public class TVMain {

	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.powerOff();
//		LGTV tv = new LGTV();
//		tv.turnOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.turnOff();
		//같은 기능이지만 삼성에서 lg로 하나 바뀌었다고 싹다 바뀌었다 => 통일하자 => 자바에선 어떻게 하는가 => 인터페이스

		TV tv = null;
//		tv = new SamsungTV();
//		tv = new LGTV();
		TVFactory factory = new TVFactory();
		tv = factory.getTV(args[0]);
		if(tv != null) {
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
		}
		
	}

}
