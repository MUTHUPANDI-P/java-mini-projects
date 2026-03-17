package com.student.service;

import java.util.*;
import java.util.stream.Collectors;

import com.student.model.Student;
import com.student.exception.InvalidMarksException;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws InvalidMarksException {
        if (s.getMarks() < 0 || s.getMarks() > 100) {
            throw new InvalidMarksException("Marks should be between 0 and 100!");
        }
        students.add(s);
    }

    public void displayAll() {
        students.forEach(System.out::println);
    }

    public void highScorers() {
        students.stream()
                .filter(s -> s.getMarks() > 70)
                .forEach(System.out::println);
    }

    public void groupByCourse() {
        Map<String, List<Student>> grouped =
                students.stream().collect(Collectors.groupingBy(Student::getCourse));

        grouped.forEach((course, list) -> {
            System.out.println("Course: " + course);
            list.forEach(System.out::println);
        });
    }

    public void sortByMarks() {
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
                .forEach(System.out::println);
    }
}