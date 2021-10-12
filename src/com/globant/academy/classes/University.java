package com.globant.academy.classes;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class University {
    private String name;
    private List<Student> students= new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public University(String name,List<Student> students, List<Teacher> teachers, List<Course> courses) {
        this.name=name;
        this.students.addAll(students);
        this.teachers.addAll(teachers);
        this.courses.addAll(courses);

    }

    public String getName() {
        return name;
    }

    public List<Course> getCoursesByStudent(Student student){
            return this.courses.stream().filter(course -> course.getStudents().contains(student)).collect(Collectors.toList());
    }
    public List<Course> getCoursesByTeacher(Teacher teacher){
        return this.courses.stream().filter(course -> course.getTeacher()==teacher).collect(Collectors.toList());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student) ;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course) ;
    }
}
