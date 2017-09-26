package com.yanggy.springboot.aop;

import com.yanggy.springboot.Utils.ResponseEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Aspect
@Component
public class AopException {
    @Pointcut("execution(public * com.yanggy.springboot.api.*.*(..))")
    private void controllerAspect(){}

    @Around("controllerAspect()")
    public Object exceptionCheck(ProceedingJoinPoint pjp) {

        Object result = null;
        String methodName = pjp.getSignature().getName();
        try {
            Object[] args = pjp.getArgs();
            result = pjp.proceed(args);
        } catch (Throwable e1) {
            return mapResponse(result, e1);
        } finally {
            //
        }
        return mapResponse(result, null);
    }

    private Object mapResponse(Object methodResult, Throwable e) {
        if(null != e) {
            return new ResponseEntity("0","01000001",e.getMessage());
        }
        return new ResponseEntity(methodResult);
    }

}
