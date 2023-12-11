package aop2;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Aspect
public class Common {
	
	long starttime = System.currentTimeMillis();
	
	@Pointcut("execution(* aop2..*.*(..))")
	public void pc() {
	}
	
	@Before("pc()")
	public void a() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH:mm:ss");
		String date_str = sdf.format(new Date(starttime));
		System.out.println("======" + date_str + "======");
	}
	
	@After("pc()")
	public void b() {
		long endtime = System.currentTimeMillis();
		System.out.println("=====메서드 소요시간" + (endtime - starttime) + "========");
	}
	
	@Around("pc()")
	public void c(ProceedingJoinPoint joinPoint) {
		
		try {
			System.out.println("=====메서드 수행이전입니다=====");
			System.out.println("target메서드 명: " + joinPoint.toShortString());
			System.out.println("target클래스 명: " + joinPoint.getTarget());
			System.out.println("target메서드의 매개변수: " + Arrays.toString(joinPoint.getArgs()));
			Object returnValue = joinPoint.proceed();//선택한 target메서드들을 실행
			if(returnValue != null) {
				System.out.println("target메서드 리턴값= " + returnValue);
			}
			System.out.println("=====메서드 수행이후입니다=====");
			System.out.println("");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
