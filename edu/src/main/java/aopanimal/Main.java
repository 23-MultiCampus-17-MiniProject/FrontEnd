package aopanimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopanimal/animal.xml");
		
		Animal[] animals = new Animal[3];
		animals[0] = factory.getBean("cat", Animal.class);
		animals[1] = factory.getBean("dog", Animal.class);
		animals[2] = factory.getBean("rabbit", Animal.class);
		
		for(Animal a : animals) {
			a.lunch();
		}
	}

}
