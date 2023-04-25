package com.xmspace.step01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: 正常情况下我们如何解耦合
 * @author: 小明长高高
 * @date: 2023/4/25 21:35
 **/
public class BeanFactory {
    private static Properties env = new Properties();
    //1. 将配置文件的数据抽取到Map类型的Properties中
    static{
        InputStream resourceAsStream = BeanFactory.class.getResourceAsStream("/application.properties");
        try {
            env.load(resourceAsStream);
            assert resourceAsStream != null;
            resourceAsStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //2. 耦合的代码,这个方法只能创建StudentServiceImpl,里面写死了
    public static void getUserService() throws Exception {
        StudentService studentService = new StudentServiceImpl();
        studentService.play();
    }
    //3. 优化后的代码根据key获取自己想要的实现类,这个方法达到解耦合的功效
    public static Object getUserServiceThink(String key) throws Exception{
        return Class.forName(env.getProperty(key)).newInstance();
    }
}
