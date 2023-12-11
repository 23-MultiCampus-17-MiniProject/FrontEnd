package aopanimal;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnimalAdvice {
	
	public void replay(ProceedingJoinPoint joinPoint) {
		
		try {
			System.out.println("오늘은 뭐 먹을거에요?");
			Object res = joinPoint.proceed();
			System.out.println(res);
			System.out.println("");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
}
