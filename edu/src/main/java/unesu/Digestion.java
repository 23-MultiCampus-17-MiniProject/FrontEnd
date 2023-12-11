package unesu;

import org.springframework.beans.factory.annotation.Autowired;

public class Digestion {
	
	@Autowired
	Food food;
	
	public void cycle(String name) {
		eat(name);
		digest(name);
		excrete(name);
	}
	
	
	public void eat(String name) {
		
		double random = Math.random();
		if(random > 0.7) {
			System.out.println(name + "(이)가" + food.getFoodName() + "을(를) 무사히 먹었다.");
		}else {
			System.out.println(name + "(이)가" + food.getFoodName() + "을(를) 급히 먹다 체했다!");
		}
		
	}
	
	public void digest(String name) {
		double random = Math.random();
		if(random > 0.7) {
			System.out.println(food.getFoodName() + "가 소화되고 있다.");
		}else {
			System.out.println(food.getFoodName() + "가 상해서 배탈이 났다!");
		}
		
	}
	
	public void excrete(String name) {
		double random = Math.random();
		if(random > 0.7) {
			System.out.println(name + "(이)가 무사히 똥을 쌋다.");
		}else {
			System.out.println(name + "(이)가 변비에 걸려 싸질 못했다!");
		}
	}
}
