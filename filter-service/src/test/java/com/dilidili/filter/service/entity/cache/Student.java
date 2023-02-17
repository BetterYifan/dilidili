package com.dilidili.filter.service.entity.cache;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private String name;
    private Integer age;

    Student() {

    }

    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
