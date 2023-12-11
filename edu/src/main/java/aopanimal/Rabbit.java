package aopanimal;

public class Rabbit implements Animal{

	@Override
	public String lunch() {
		System.out.println("당근 먹었습니다");
		return "Rabbit-당근";
	}

}
