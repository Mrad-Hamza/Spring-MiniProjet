package com.esprit.spring.journalisation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggingAspect {
    private static final Logger l = LogManager.getLogger(LoggingAspect.class);
    @Before("execution(* com.esprit.spring.services.StockServiceImpl.*(..))")
            public void logMethodEntry(JoinPoint joinPoint){
                String name=joinPoint.getSignature().getName();
                l.info("in method"+ name +":");
    }

    @After("execution(* com.esprit.spring.services.StockServiceImpl.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name =joinPoint.getSignature().getName();
        l.info("out of "+ name + ":");
    }
    
    

}