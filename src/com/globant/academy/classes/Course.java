package com.globant.academy.classes;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private  String classRoom;
    private  Teacher teacher;
    private List<Student> students= new ArrayList<Student>();

    public Course(String name, String classRoom) {
        this.name = name;
        this.classRoom = classRoom;
    }

    public Course(String name, String classRoom,  List<Student> students,Teacher teacher) {
        this.name = name;
        this.classRoom = classRoom;
        this.teacher = teacher;
        for (Student student :students){
            this.students.add(student);
        }

    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudents(List<Student> students) {
        for (Student student:students) {
            this.students.add(student);
        }
    }

    public  void  removeStudents(List<Student> students){
        for (Student student:students) {
            this.students.remove(student);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }




}
