package org.sdet.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodTracer {
    public static final String TAG = MethodTracer.class.getSimpleName();

    @Before("execution (protected void org.sdet.aspectj.MainActivity.onCreate(android.os.Bundle))")
    public void adviceOnCreate(JoinPoint joinPoint) {
        Log.e(TAG, joinPoint.toString());
    }

    @Before("execution (private void org.sdet.aspectj.MainActivity.method4Execution(..))")
    public void adviceOnExecution(JoinPoint joinPoint) {
        Log.v(TAG, joinPoint.toString());
    }

    @Before("call (private void org.sdet.aspectj.MainActivity.method4Call(..))")
    public void adviceOnCall(JoinPoint joinPoint) {
        Log.v(TAG, joinPoint.toString());
    }

    // withincode: 在functionB方法内
    @Pointcut("withincode(org.sdet.aspectj.MainActivity.functionB(..))")
    public void invokeFuntionB(){}

    // call:调用dummy方法
    @Pointcut("call(org.sdet.aspectj.MainActivity.dummy(..))")
    public void invokeDummy(){}

    // 在functionB内调用dummy方法
    @Pointcut("invokeFuntionB() && invokeDummy()")
    public void invokeDummyInsideFunctionB(){}

    @Before("invokeDummyInsideFunctionB()")
    public void beforeInvokeDummyInsideFunctionB(JoinPoint joinPoint) {
        System.out.printf("Before.InvokeDummyInsideFunctionB.advice() called on '%s'", joinPoint);
    }
}
