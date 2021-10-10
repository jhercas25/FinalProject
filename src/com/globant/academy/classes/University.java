package com.globant.academy.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class University {
    private String name;
    private List<Student> students= new ArrayList<Student>();
    private List<Teacher> teachers = new ArrayList<Teacher>();
    private List<Course> courses = new ArrayList<Course>();

    public University(String name,List<Student> students, List<Teacher> teachers, List<Course> courses) {
        this.name=name;
        for (Student student:students) {
            this.students.add(student);
        }
        for (Teacher teacher:teachers) {
            this.teachers.add(teacher);
        }
        for (Course course:courses) {
            this.courses.add(course);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCoursesByStudent(Student student){
            return this.courses.stream().filter(course -> course.getStudents().indexOf(student)>=0).collect(Collectors.toList());
    }
    public List<Course> getCoursesByTeacher(Teacher teacher){
        return this.courses.stream().filter(course -> course.getTeacher()==teacher).collect(Collectors.toList());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
