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


    public Map<String,String>  info(){
        Map<String,String> data= new HashMap<>(){};
        data.put("Name",this.getName());
        data.put("Type","Full-Time");
        data.put("BaseSalary",this.getBaseSalary()+"");
        data.put("Parameters","YE :"+this.yearsOfExperience);
        data.put("Salary",this.calculateSalary()+"");
        return  data;
    }


}
