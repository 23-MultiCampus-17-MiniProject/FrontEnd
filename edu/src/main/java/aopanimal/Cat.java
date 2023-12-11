package aopanimal;

public class Cat implements Animal{

	@Override
	public String lunch() {
		System.out.println("생선 먹었습니다");
		return "Cat-생선";
	}

}
