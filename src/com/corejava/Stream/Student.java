package com.corejava.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {


    private String name;
    private List<Student> students;


    public Student(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        final List<Student> students = new ArrayList<Student>();

        students.stream()
                .filter(s -> s.getName().startsWith("J"))
                .collect(Collectors.toList());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "John";
        this.name = "Gabriel";
        this.name = "Jennifer";
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
