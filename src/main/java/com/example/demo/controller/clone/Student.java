package com.example.demo.controller.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020-08-27 17:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable {
    private String name;
    private int age;
    private Major major;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
