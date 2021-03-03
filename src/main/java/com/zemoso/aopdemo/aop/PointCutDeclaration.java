package com.zemoso.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class PointCutDeclaration {
    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());
    // setup pointcut declarations
//    @Pointcut("execution(* com.zemoso.aopdemo.controller.*.*(..))")
//    private void forControllerPackage() {}
//
//    @Pointcut("execution(* com.zemoso.aopdemo.service.*.*(..))")
//    private void forServicePackage() {}
//
//    @Pointcut("execution(* com.zemoso.aopdemo.dao.*.*(..))")
//    private void forDaoPackage() {}
//
//    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
//    private void forAppFlow() {}

    // add @Before advice
    @Before("execution(* com.zemoso.aopdemo.controller.*.*(..))")
    public void before(JoinPoint theJoinPoint) {
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg);
        }
    }
//
//    // add @After advice


    // add @Around advice
    @Around("execution(* com.zemoso.aopdemo.controller.*.*(..))")
    public Object around(ProceedingJoinPoint theJoinPoint) throws Throwable {
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Around: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg.getClass());
        }
        Object result = theJoinPoint.proceed(args);
        myLogger.info("Returning " + result);
        return result;

    }

    @After("execution(* com.zemoso.aopdemo.controller.*.*(..))")
    public void after(JoinPoint theJoinPoint) {
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @After: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg);
        }
    }

    @AfterThrowing("execution(* com.zemoso.aopdemo.controller.*.*(..))")
    public void afterThrowing(JoinPoint theJoinPoint) {
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterThrowing: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg);
        }
    }

}
