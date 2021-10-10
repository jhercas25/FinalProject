package com.globant.academy.classes;

public class FullTimeTeacher extends  Teacher{
    private  float yearsOfExperience;

    public FullTimeTeacher(String name, float baseSalary, float yearsOfExperience) {
        super(name, baseSalary);
        this.yearsOfExperience = yearsOfExperience;
    }

    public float  calculateSalary(){
        return this.baseSalary * this.yearsOfExperience;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

}
