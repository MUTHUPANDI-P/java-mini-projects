package com.student.app;

import java.util.Scanner;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.exception.InvalidMarksException;

public class StudentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1 Add Student");
            System.out.println("2 View All Students");
            System.out.println("3 Students with Marks > 70");
            System.out.println("4 Group Students by Course");
            System.out.println("5 Sort Students by Marks");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter Name: ");
                        String name = sc.next();

                        System.out.print("Enter Course: ");
                        String course = sc.next();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        Student s = new Student(id, name, course, marks);
                        service.addStudent(s);

                        System.out.println("Student Added!");
                        break;

                    case 2:
                        service.displayAll();
                        break;

                    case 3:
                        service.highScorers();
                        break;

                    case 4:
                        service.groupByCourse();
                        break;

                    case 5:
                        service.sortByMarks();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InvalidMarksException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}