package com.example.aspect.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CustomLoggingFramework {

    @Around("@annotation(com.example.aspect.annotation.LogreqAndRes)")
    public Object capturaRequestAndReponse(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("execution started {}",joinPoint.getSignature());
        log.info("Request body {}",new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
        Object object=joinPoint.proceed();
        log.info("execution ended {}",joinPoint.getSignature());
        log.info("Request body {}",new ObjectMapper().writeValueAsString(object));
        return object;
    }
}
