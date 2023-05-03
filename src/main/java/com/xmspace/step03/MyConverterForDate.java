package com.xmspace.step03;

import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/3 13:37
 **/
@Data
public class MyConverterForDate implements Converter<String, Date> {
    //1.使用DI注入的方式配置日期格式
    private String pattern;
    //2.实现Converter类自定义类型转换器。这里我们实现的是字符串转日期格式
    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
