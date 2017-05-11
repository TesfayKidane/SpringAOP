package edu.mum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import edu.mum.domain.User;

@Aspect
@Component
public class LoggingAspect {

//	@Before("execution(* edu.mum.service..*(..))")
//	public void implicitPointCut(JoinPoint joinPoint) {
//		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
//				+ joinPoint.getSignature().getName() + "    **********");
//	}

// Isolates/restricts WHERE @Logging can be applied
//	@Pointcut("execution(* edu.mum.service..*(..))")
//  @Pointcut("execution(* edu.mum.service..update(..))") // - If you want to
//  AOP ONLY updates...IGNORES Save
//	public void applicationMethod() {
//	}

// Annotation
//	@Pointcut("@annotation(edu.mum.aspect.annotation.Logging)")
//	public void logging() {
//	}

	// Remove logging() && AND it will do a "regular"[no annotation] execution
	// Point cut.
	// @Before("logging() && applicationMethod()")
//	@Before("applicationMethod()")
//	public void logResource(JoinPoint joinPoint) {
//		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
//				+ joinPoint.getSignature().getName() + "    **********");
//	}

	@Pointcut("execution(* edu.mum.service..*(..))")
	public void longArgs() {
	}
	
//	@Pointcut("execution(* edu.mum.service..*(Long))")
//	public void longArgs() {
//	}
	
/*	@Pointcut("execution(* edu.mum.service..*())")
	public void longArgs() {
	}*/

//	@Before("longArgs()")
//	public void logWithArgs(JoinPoint joinPoint){
//		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
//				+ joinPoint.getSignature().getName() + "    **********");
//	}
	// ----#2-------
//	@Pointcut("execution(* edu.mum.service..save(..))")
//	public void testOrder() {
//	}

	/*@Pointcut(" args(order)  ")
	public void orderArgs(Order order) {
	}
*/
	// --------------------------------------------------------------------
	// @Before("testOrderCombo(awder)") // Explicit version #1
	// @Before("testOrder() && orderArgs(awder)") // EXPLICIT Version #2
	// @Before("execution(* edu.mum.service..save(..)) && args(awder) ") //
	// Implicit version #3
//	public void testExecution(Order awder) {
//		System.out.println();
//		System.out.println("BIND 'awder' to Order in Advice -- in save");
//		System.out.println("Order Number: " + awder.getOrderNumber());
//
//	}
	@Pointcut("execution(* edu.mum.service..*(..)) && args(user)")
	public void logResourceWithArgs(User user){}
	@Before("logResourceWithArgs(user)")
	public void logResourceName(JoinPoint joinPoint, User user) {
		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
		+ joinPoint.getSignature().getName() + "  user : " + user.getFirstName() + "  **********");
	}

}
