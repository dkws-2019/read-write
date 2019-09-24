package com.liuchao.readwrite.config;

import com.liuchao.readwrite.annotation.ReadAnnotation;
import com.liuchao.readwrite.annotation.WriteAnnotation;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAop {
    @Pointcut(value = "@annotation(com.liuchao.readwrite.annotation.WriteAnnotation)")
    public void writePointcut(){

    }

    /*@Pointcut(value = "@annotation(com.liuchao.readwrite.annotation.ReadAnnotation)")
    public void readPointcut(){

    }*/
    @Pointcut("execution(public * com.liuchao.readwrite.service..*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object beforWrite(ProceedingJoinPoint pdj){
        Class<?> aClass = pdj.getTarget().getClass();
        String methodName = pdj.getSignature().getName();
        MethodSignature methodSignature=(MethodSignature)pdj.getSignature();
        Class[] parameterTypes = methodSignature.getParameterTypes();
        Method method=null;
        try {
            method= aClass.getDeclaredMethod(methodName, parameterTypes);
            WriteAnnotation writeAnnotation = method.getAnnotation(WriteAnnotation.class);
            if(writeAnnotation!=null){
                DBContextHolder.master();
            }
            ReadAnnotation readAnnotation = method.getAnnotation(ReadAnnotation.class);
            if(readAnnotation!=null){
                DBContextHolder.slave();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return pdj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;

    }

}
