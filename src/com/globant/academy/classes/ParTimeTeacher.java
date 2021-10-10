package com.globant.academy.classes;

public class ParTimeTeacher extends  Teacher{
    private float workingHoursPerWeek;

    public ParTimeTeacher(String name, float baseSalary, float workingHoursPerWeek) {
        super(name, baseSalary);
        this.workingHoursPerWeek = workingHoursPerWeek;
    }

    public float  calculateSalary(){
        return this.baseSalary * this.workingHoursPerWeek;
    }

    public float getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }

    public void setWorkingHoursPerWeek(float workingHoursPerWeek) {
        this.workingHoursPerWeek = workingHoursPerWeek;
    }
}
