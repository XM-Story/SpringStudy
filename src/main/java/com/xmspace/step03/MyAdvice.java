package com.xmspace.step03;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description: 用MethodBeforeAdvice接口实现接口的代理增强，额外功能运行在目标方法之前。
 * @author: 小明长高高
 * @date: 2023/5/3 18:01
 **/
public class MyAdvice implements MethodBeforeAdvice {
    /**
     * @param method 原始目标方法
     * @param objects 原始目标方法的参数
     * @param o 原始目标方法所属对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("MyAdvice.before");
    }
}
