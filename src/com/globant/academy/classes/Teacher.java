package com.globant.academy.classes;

public abstract class Teacher {
    private String name;
    protected float baseSalary;

    public Teacher(String name, float baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public  abstract  float  calculateSalary();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }
}
