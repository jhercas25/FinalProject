package com.globant.academy.classes;

import java.util.UUID;

public class Student {
    private UUID uuid;
    private String name;
    private float age;

    public Student( String name, float age) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public UUID getId() {
        return uuid;
    }
}
