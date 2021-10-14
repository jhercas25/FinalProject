package com.globant.academy.classes;

import java.util.HashMap;
import java.util.Map;

public class ParTimeTeacher extends  Teacher{
    private float workingHoursPerWeek;

    public ParTimeTeacher(String name, float baseSalary, float workingHoursPerWeek) {
        super(name, baseSalary);
        this.workingHoursPerWeek = workingHoursPerWeek;
    }

    public float  calculateSalary(){
        return this.baseSalary * this.workingHoursPerWeek;
    }

    public Map<String,String>  info(){
        Map<String,String> data= new HashMap<>(){};
        data.put("Name",this.getName());
        data.put("Type","Par-Time");
        data.put("BaseSalary",this.getBaseSalary()+"");
        data.put("Parameters","HPW :"+this.workingHoursPerWeek);
        data.put("Salary",this.calculateSalary()+"");
        return  data;
    }
}
