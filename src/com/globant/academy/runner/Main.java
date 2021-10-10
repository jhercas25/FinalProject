package com.globant.academy.runner;

import com.globant.academy.classes.*;

import java.util.*;
import java.util.zip.CheckedOutputStream;

public class Main {

    public static void main(String[] args) {

        List<Student> students=new ArrayList<Student>();
        List<Teacher> teachers =new ArrayList<Teacher>();
        List<Course> courses =new ArrayList<Course>();

        students = loadStudents();
        teachers = loadTeachers();
        courses = loadCourses(students,teachers);

        University myUniversity=new University("New Order",students,teachers,courses);
        System.out.println("/======================================================/");
        System.out.println("Wellcome to " +myUniversity.getName()+ " university tracker");
        System.out.println("/======================================================/");


        boolean exit=false;

        do{
            System.out.println("--- Choose some option to get more information --- ");
            System.out.println("1. Professors  ");
            System.out.println("2. Students");
            System.out.println("3. Courses");
            System.out.println("4. Exit");
            String option = getOption(false);
            String leftAlignFormat;
            switch (option){
                case "1" :
                    System.out.println("__________ Professors __________ ");
                    leftAlignFormat = "| %-15s | %-15s | %-15f | %-15s |%n";

                    System.out.format("+-----------------+-----------------+------------------+------------------+%n");
                    System.out.format("|      Name       |      Type       |      Salary      |      Course      |%n");
                    System.out.format("+-----------------+-----------------+------------------+------------------+%n");


                    for (Teacher teacher: myUniversity.getTeachers()) {
                        System.out.format(leftAlignFormat, teacher.getName() , teacher.getClass().getName().indexOf("Full")>0?"FulLtime":"Partime",teacher.calculateSalary(),myUniversity.getCoursesByTeacher(teacher).get(0).getName() );
                    }
                    System.out.format("+-----------------+------+%n");
                    break;
                case "2":
                    System.out.println("__________ Students __________ ");
                    leftAlignFormat = "| %-15s | %-15s | %-19s |%n";

                    System.out.format("+-----------------+-----------------+----------------------+%n");
                    System.out.format("|      Name       |      Age        |      Courses         |%n");
                    System.out.format("+-----------------+-----------------+----------------------+%n");

                    for (Student student: myUniversity.getStudents()) {
                        String coursesAssigned="";
                        for (Course course: myUniversity.getCoursesByStudent(student) ) {
                            coursesAssigned+="\n\t\t\t\t\t\t\t\t\t-"+course.getName() +" CR:"+course.getClassRoom();
                        }

                        System.out.format(leftAlignFormat, student.getName() , student.getAge(), myUniversity.getCoursesByStudent(student).size()>0?coursesAssigned:"No Assigned" );
                    }
                    System.out.format("+-----------------+------+%n");

                    break;
                case "3":
                    System.out.println("__________ Courses __________ ");
                    leftAlignFormat = "| %-15s | %-15s | %-18s | %-15s |%n";

                    System.out.format("+-----------------+-----------------+--------------------+------------------+%n");
                    System.out.format("|      Name       |     Classroom   | #Students Assigned |      Teacher     |%n");
                    System.out.format("+-----------------+-----------------+--------------------+------------------+%n");

                    for (Course course: myUniversity.getCourses()) {

                        System.out.format(leftAlignFormat, course.getName() , course.getClassRoom(), course.getStudents().size(), course.getTeacher().getName() );
                    }
                    System.out.format("+-----------------+------+%n");


                    break;
                case  "4":
                    exit=true;
                    break;
                default:
                    System.out.println("--- Choose a valid option --- ");
                    break;
            }

        }
        while(!exit);


    }



    private static List<Teacher> loadTeachers() {
       List<Teacher> teachers =new ArrayList<>();
       teachers.add(new FullTimeTeacher("John",5000,5));
       teachers.add(new FullTimeTeacher("Laura",5000,10));
       teachers.add(new ParTimeTeacher("Steven",5000,20));
       teachers.add(new ParTimeTeacher("Albert",5000,18));

        return teachers;
    }

    private static List<Student> loadStudents() {
        List<Student> students =new ArrayList<>();
        students.add(new Student("Victor",22));
        students.add(new Student("Cesar",20));
        students.add(new Student("Ange",21));
        students.add(new Student("Andrew",22));
        students.add(new Student("Johana",23));
        students.add(new Student("Linda",22));

        return students;

    }

    private static List<Course> loadCourses(List<Student> students, List<Teacher>teachers ) {
        List<Course> courses =new ArrayList<Course>();
        List<Student>studentsSelected = new ArrayList<Student>();
        String[] names={"Biology","Large Weapons","Ninjan way","Surf"};
        String[] classrooms={"A22","B51","F29","U42"};
        List<Integer> posibleStudents= new ArrayList<>();
        for(int i=0;i<6;i++) posibleStudents.add(i);

        for (int j=0;j<names.length;j++){
            Collections.shuffle(posibleStudents);
           for(int i=0;i<=rand(students.size()-2);i++){

               studentsSelected.add(students.get(posibleStudents.get(i)));

           }

           courses.add(new Course(names[j],classrooms[j],studentsSelected,teachers.get(j)));
           studentsSelected.clear();

        }

        return courses;
    }

    private static int rand(int length ){
        double f = Math.random()/Math.nextDown(1.0);
        double x = 1*(1.0-f)+length*f;
        int r =(int) Math.round(x);
        return r ;
    }

    private static String getOption(boolean wantNumeric){
        Scanner scan =new Scanner(System.in);
        String answer ="";
        while (answer.isBlank() || answer.isBlank()){
            answer= scan.nextLine();
            if (wantNumeric){
                if(!isNumeric(answer)){
                    answer="";
                }
            }
        }

        return answer;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }



}
