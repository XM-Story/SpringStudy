package com.xmspace.step01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/2 15:00
 **/
@Data
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private int age;
    private Student student;
}
