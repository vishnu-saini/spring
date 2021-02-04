package com.vishnu.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.vishnu.spring.aop.springaop.data.*.*(..))")
	public void dataLayerExecution() {
	}

	@Pointcut("execution(* com.vishnu.spring.aop.springaop.business.*.*(..))")
	public void businessLayerExecution() {
	}

	@Pointcut("dataLayerExecution() && businessLayerExecution()")
	public void allLayerExecution() {
	}

	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {
	}

	@Pointcut("within(com.vishnu.spring.aop.springaop.data..*)")
	public void dataLayerExecutionWithWithin() {
	}

	@Pointcut("@annotation(com.vishnu.spring.aop.springaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {
	}

}
