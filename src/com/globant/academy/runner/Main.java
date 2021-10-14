package com.globant.academy.runner;

import com.globant.academy.classes.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Student> students;
        List<Teacher> teachers;
        List<Course> courses;

        students = loadStudents();
        teachers = loadTeachers();
        courses = loadCourses(students,teachers);

        University myUniversity=new University("New Order",students,teachers,courses);
        System.out.println("/======================================================/");
        System.out.println("Welcome to " +myUniversity.getName()+ " university tracker");
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
            String suboption="0";

            switch (option){
                case "1" :
                    System.out.println("__________ Professors __________ ");
                    leftAlignFormat = "| %-3d | %-15s | %-15s | $%-15s | %-15s | $%-15s | %-15s |%n";

                    System.out.format("+-----+-----------------+-----------------+------------------+------------------+------------------+------------------+%n");
                    System.out.format("|  #  |      Name       |      Type       |  Base Salary     |      Parameter   |      Salary      |      Course      |%n");
                    System.out.format("+-----+-----------------+-----------------+------------------+------------------+------------------+------------------+%n");
                    int index = 0;
                    for (Teacher teacher: myUniversity.getTeachers()) {

                        System.out.format(leftAlignFormat,index,
                                teacher.info().get("Name"),
                                teacher.info().get("Type"),
                                teacher.info().get("BaseSalary"),
                                teacher.info().get("Parameters"),
                                teacher.info().get("Salary"),
                                myUniversity.getCoursesByTeacher(teacher).get(0).getName() );
                        index++;
                    }
                    System.out.format("+-----------------+------+%n");
                    System.out.format("YE: Years of experience; HPW : Hours per week ------------- +%n");

                    break;
                case "2":
                    System.out.println("__________ Students __________ ");
                    leftAlignFormat = "| %-3d | %-15s | %-15s |%n";

                    System.out.format("+-----+-----------------+-----------------+%n");
                    System.out.format("|   # |      Name       |      Age        |%n");
                    System.out.format("+-----+-----------------+-----------------+%n");
                    index=0;
                    for (Student student: myUniversity.getStudents()) {
                        System.out.format(leftAlignFormat,index,
                                            student.getName() ,
                                            student.getAge());
                        index++;
                    }
                    System.out.format("+-----------------+------+%n");

                    while(!suboption.equals("4")){
                        System.out.println("Options 1.Add; 2.Show more info;  4.Back");
                        suboption=getOption(false);
                        switch (suboption){
                            case "1":
                                System.out.println("To add a new student please enter a name:") ;
                                String name=getOption(false);
                                System.out.println("now the age") ;
                                float age=Float.parseFloat(getOption(true)) ;
                                int couseSelected=-1;
                                while(couseSelected<0) {
                                    System.out.println("Select a course ");
                                    System.out.println("__________ Courses __________ ");
                                    leftAlignFormat = "| %-3d | %-15s |%n";
                                    index =0;
                                    for (Course course : myUniversity.getCourses()) {
                                        System.out.format(leftAlignFormat,index, course.getName());
                                        index++;
                                    }
                                    couseSelected=Integer.parseInt(getOption(true));
                                    if(couseSelected>myUniversity.getCourses().size()-1){
                                        System.out.println("Select a valid student");
                                        couseSelected=-1;
                                    }
                                }
                                Student newStudent =new Student(name,age);
                                myUniversity.addStudent(newStudent);
                                myUniversity.getCourses().get(couseSelected).addStudents(newStudent);
                                System.out.println("Student created");

                                break;
                            case "2":
                                System.out.println("Select a student to see its courses assigned");
                                int studentSelected = Integer.parseInt(getOption(true));

                                System.out.println("__________ "+myUniversity.getStudents().get(studentSelected).getName() +" __________ ");
                                leftAlignFormat = "| %-3d | %-15s | %-15s |%n";
                                System.out.println("__________ Courses Assigned __________ ");
                                System.out.format("+-----+-----------------+-----------------+%n");
                                System.out.format("|   # |      Name       |   Class room    |%n");
                                System.out.format("+-----+-----------------+-----------------+%n");
                                index=0;
                                for (Course course: myUniversity.getCoursesByStudent(myUniversity.getStudents().get(studentSelected)) ) {
                                    System.out.format(leftAlignFormat,index, course.getName(),course.getClassRoom());
                                    index++;
                                }
                                System.out.println("__________ Enter Y key to go back __________ ");
                                getOption(false);
                                suboption="4";

                                break;
                            case "4":
                                System.out.format("+----------<-back+------+%n");
                                break;

                            default:
                                System.out.println("Enter a valid option");
                                break;
                        }
                    }

                    break;
                case "3":
                    System.out.println("__________ Courses __________ ");
                    leftAlignFormat = "| %-5d | %-15s | %-15s |%n";

                    System.out.format("+-------+-----------------+-----------------+%n");
                    System.out.format("|   #   |      Name       |     Classroom   |%n");
                    System.out.format("+-------+-----------------+-----------------+%n");
                    index=0;
                    for (Course course: myUniversity.getCourses()) {
                        System.out.format(leftAlignFormat,index,
                                            course.getName() ,
                                            course.getClassRoom());
                        index++;
                    }
                    System.out.format("+-----------------+------+%n");

                    while(!suboption.equals("4")){
                        System.out.println("Options 1.Add 2.Show details 4.Back");
                        suboption=getOption(false);
                        switch (suboption){
                            case "1":
                                System.out.println("To create a new course please enter its name");
                                String name= getOption(false);
                                System.out.println("what is the classroom assigned");
                                String classRoom= getOption(false);

                                System.out.println("Select a teacher");
                                System.out.println("__________ Teachers __________ ");
                                int teacherSelected=-1;
                                while (teacherSelected<0){
                                    index=0;
                                    leftAlignFormat = " | %-3d | %-15s |%n";
                                    for (Teacher teacher : myUniversity.getTeachers()) {
                                        System.out.format(leftAlignFormat, index,teacher.getName());
                                        index++;
                                    }
                                    teacherSelected=Integer.parseInt(getOption(true));
                                    if(teacherSelected>myUniversity.getTeachers().size()){
                                        teacherSelected=-1;
                                        System.out.println("Select a valid teacher");
                                    }

                                }
                                Course newCourse= new Course(name,classRoom);
                                newCourse.setTeacher(myUniversity.getTeachers().get(teacherSelected));
                                myUniversity.addCourse(newCourse);

                                System.out.println("Course created");
                                System.out.println("Select a students to add");
                                System.out.println("__________ Students __________");
                                boolean moreStudents=true;
                                int studentSeleted;

                                while (moreStudents){
                                    index=0;
                                    List<Student> studentsAssigned=newCourse.getStudents();
                                    for (Student student : myUniversity.getStudents()) {
                                        if(studentsAssigned.contains(student)){
                                            leftAlignFormat = "\u001B[31m | %-5d | %-15s |%n\u001B[31m";
                                        }else{
                                            leftAlignFormat = "\u001B[0m | %-5d | %-15s |%n\u001B[0m";
                                        }
                                        System.out.format(leftAlignFormat,index, student.getName());
                                        index++;
                                    }

                                    studentSeleted=Integer.parseInt(getOption(true));
                                    if (studentSeleted>myUniversity.getStudents().size() || studentsAssigned.contains(myUniversity.getStudents().get(studentSeleted))){
                                        System.out.println(" \u001B Select a valid student \u001B");
                                    }else{
                                        newCourse.addStudents(myUniversity.getStudents().get(studentSeleted));
                                        System.out.println(" \u001B Do you want to add more students enter 1 or any key to quit \u001B");
                                        moreStudents=getOption(false).equals("1");
                                    }

                                }

                                break;
                            case "2":
                                System.out.println("Select a course to show its details");
                                int courseSelected= Integer.parseInt(getOption(true));
                                leftAlignFormat = "| %-5d | %-15s | %-15s |%n";
                                System.out.format("+---------"+myUniversity.getCourses().get(courseSelected).getName() +"--+------+%n");
                                System.out.format("+-------+------------------+-----------------+%n");
                                System.out.format("|   #   |    Students      |    Teacher      |%n");
                                System.out.format("+-------+------------------+-----------------+%n");
                                index=0;
                                for (Student student: myUniversity.getCourses().get(courseSelected).getStudents()) {
                                    System.out.format(leftAlignFormat,index,
                                            student.getName()
                                            ,index==0?myUniversity.getCourses().get(courseSelected).getTeacher().getName():"");
                                    index++;
                                }
                                System.out.format("+-----------------+------+%n");
                                System.out.println("__________ Enter Y key to go back __________ ");
                                getOption(false);
                                suboption="4";

                                break;
                            case "4":
                                System.out.format("+----------<-back+------+%n");
                                break;

                            default:
                                System.out.println("Enter a valid option");
                                break;
                        }
                    }

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
        List<Course> courses =new ArrayList<>();
        List<Student>studentsSelected = new ArrayList<>();
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
        return (int) Math.round(x) ;
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
