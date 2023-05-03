package com.xmspace.step03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/3 19:50
 **/
//自定义方法拦截器实现动态代理
public class MyInterceptor implements MethodInterceptor {
    /**
     * @param methodInvocation 原始方法
     * @return Object 拦截器拦截原始方法返回值，以便于我们修改
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MyInterceptor.invoke before");
        //执行原始方法 获取返回值并返回
        Object proceed = methodInvocation.proceed();
        System.out.println("MyInterceptor.invoke after");
        return proceed;
    }
}
