package com.xmspace.All;

import com.xmspace.step03.Animal;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/3 10:26
 **/
public class test03 {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.getBean("initBean");
        applicationContext.close();
    }
    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Animal animal = (Animal) applicationContext.getBean("animal");
        System.out.println(animal);
    }
}
