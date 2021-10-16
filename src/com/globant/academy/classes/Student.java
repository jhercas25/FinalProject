package com.globant.academy.classes;

import java.util.UUID;

public class Student {
    private String uuid;
    private String name;
    private float age;

    public Student( String name, float age) {
        this.uuid = UUID.randomUUID().toString().split("-")[0];
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public float getAge() {
        return age;
    }

}
