package com.example.student;

public class Main {

    public static void main(String[] args) {

        Student student =
            new Student(101, "Ravi", "Computer Science", 20);

        System.out.println("Student Management System");
        System.out.println("-------------------------");

        student.displayStudent();
    }
}