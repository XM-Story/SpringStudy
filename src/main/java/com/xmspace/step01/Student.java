package com.xmspace.step01;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/25 21:27
 **/
@Data
@Builder
public class Student {
    private String name;
    private int age;
}
