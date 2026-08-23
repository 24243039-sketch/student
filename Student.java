package com.example.student;

public class Student {

    int id;
    String name;
    String department;
    int age;

    public Student(int id, String name, String department, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Age: " + age);
    }
}
