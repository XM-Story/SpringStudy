package com.xmspace.step03;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/3 10:28
 **/
public class InitBean implements InitializingBean , DisposableBean {
    //1.优先初始化的方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }
    //2.自定义的初始化方法,下一步执行
    void initCustom(){
        System.out.println("initCustom");
    }
    //3.工厂关闭后调用销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }
    //4.调用自定义的销毁方法
    void destroyCustom(){
        System.out.println("destroyCustom");
    }
}
