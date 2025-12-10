package com.thejoa703.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTrace {
	@Around("execution( public * com.thejoa703..*(..))")		// ..�� �������� �� *(..)���� ��
   public Object trace( ProceedingJoinPoint  joinPoint)  throws Throwable{
      // Ÿ�ٸ޼����� ����
      String signature = joinPoint.getSignature().toShortString();
      System.out.println(">>>> " + signature + " START! ");
      // Ÿ�ٸ޼��� ȣ��ð�Ȯ��
      long start = System.currentTimeMillis();
      // Ÿ�ٸ޼��� ȣ��
      Object  result = joinPoint.proceed();
      long end  = System.currentTimeMillis();
      System.out.println("..... 실행시간 : " + (end - start)  + "ms");
      System.out.println(">>>> " + signature + " END! ");
      return result;
   }
}