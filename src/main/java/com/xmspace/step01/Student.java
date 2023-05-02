package com.xmspace.step01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/25 21:27
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private String[] emails;
    private Set<String> tels;
    private List<String> address;
    private Map<String,String> qqs;
    private Properties p;
    private StudentService studentService;
    private List<StudentService> studentServices;
}
