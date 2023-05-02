package com.xmspace.step01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/25 22:00
 **/
public class test01 {
    @Test
    public void test01() throws Exception {
        //只能执行这个方法
        BeanFactory.getUserService();
        //解耦合后你想执行哪个类就执行哪个类，由自己掌控。
        StudentService studentService = (StudentService)BeanFactory.getUserServiceThink("studentService");
        studentService.play();
    }

    @Test
    public void test02(){
        //  Spring带来的惊喜 将各种组件通过配置文件处理完毕，如果需要就直接获取。
        //1.创建Spring的配置文件applicationContext.xml
        //2.配置好需要的bean数据
        //3.通过工厂类获得对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.play();
        //不需要转型的方式 要求配置文件的bean标签配置中只有一个bean的class配置是该类型
        StudentService studentService1 = applicationContext.getBean("studentService", StudentService.class);
        studentService1.play();
        //获取配置文件中所有的bean标签的id值
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        //根据类型获取bean标签的id值
        String[] beanNamesForType = applicationContext.getBeanNamesForType(StudentService.class);
        for (String id : beanNamesForType) {
            System.out.println("id = " + id);
        }
        //是否存在指定的id或者name的bean, 找个没有的
        if (!applicationContext.containsBean("not exists")){
            System.out.println("not exists = " + false);
        }
        //根据name属性获取对象  name属性
        //有了id为什么需要name？  每个class类型只可以有一个id 且这个id全局唯一，但是可以有多个name，逗号隔开即可，虽然意义不大
        //1.很久之前的id不支持 /开头等特殊写法会有bug 所以有了name属性  后面的版本的id的bug修复了支持了特殊写法
        //2.name属性也方便同class不同对象名的配置。
        StudentService studentService2 = (StudentService) applicationContext.getBean("p");
        studentService2.play();
        //是否存在有这个id的bean 不可以判断name
        if (applicationContext.containsBeanDefinition("studentService")) {
            System.out.println("true = " + true);
        }else{
            System.out.println("false = " + false);
        }
    }

    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Student student = applicationContext.getBean("student", Student.class);
        User user = applicationContext.getBean("user", User.class);
        System.out.println(student);
        System.out.println(user);
    }

}
