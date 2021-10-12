package com.globant.academy.classes;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private  String classRoom;
    private  Teacher teacher;
    private List<Student> students= new ArrayList<>();

    public Course(String name, String classRoom) {
        this.name = name;
        this.classRoom = classRoom;
    }

    public Course(String name, String classRoom,  List<Student> students,Teacher teacher) {
        this.name = name;
        this.classRoom = classRoom;
        this.teacher = teacher;
        this.students.addAll(students);

    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudents(Student student) {
            this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }




}
