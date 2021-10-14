package com.globant.academy.classes;


import java.util.HashMap;
import java.util.Map;

public class FullTimeTeacher extends  Teacher{
    private  float yearsOfExperience;

    public FullTimeTeacher(String name, float baseSalary, float yearsOfExperience) {
        super(name, baseSalary);
        this.yearsOfExperience = yearsOfExperience;
    }

    public float  calculateSalary(){
        return this.baseSalary * this.yearsOfExperience;
    }

    public float getParameter() {
        return yearsOfExperience;
    }



}
