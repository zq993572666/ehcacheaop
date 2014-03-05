package Advisor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonInteceper{
	public void before(){
		System.out.println("before....");
	}
}
