package com.DSalgo.Company.Relx;

//Question 1 - Find out the print Statements
//Question 2 - Create a Custom ArrayList class that should not allow duplicate elements to be added.
//Question 3 - Find the female candidate who scored the third highest mark.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class HelloWorld2 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    public static void main(String arr){
    }
}
//Output -> Hello, World

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        if (true) {
//            break;
        }
    }
}

//Output -> There is compilation error when you use 'break' outside the switch or loop.


class Add {

    private static final int a = 5;
    private static int b = 5;

    public static void main(String[] args) {
        int c = a + b;
        System.out.println(c);
    }
}

class Student {
    private String name;
    private int age;
    private int marks;
    private String gender;

    public Student(String name, int age, int marks, String gender) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.gender = gender;
    }

    // Getters for the attributes
    public String getGender() {
        return gender;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student -> name: " + name + ", age: " + age + ", marks: " + marks + ", gender: "+ gender;
    }
}

public class Relx{
    public static void main(String[] args)
    {
        //Solution1
        Add.main(new String[]{"args"});
        HelloWorld.main(new String[]{"args"});
        HelloWorld2.main(new String[]{"args"});

        System.out.println(256 + 'b' + 'i' + 't'); // 256 + 98 + ... = 575
        System.out.println('a' + 'b' + 'c'); // 97 + 98

        //Solution2
        CustomArrayList<Integer> customList = new CustomArrayList<>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        customList.add(2);
        customList.add(1);

        System.out.println(customList);

        //Solution3
        Student s1 = new Student("X", 12, 90, "Male");
        Student s2 = new Student("Y", 15, 88, "Female");
        Student s3 = new Student("A", 16, 83, "Female");
        Student s4 = new Student("B", 22, 77, "Male");
        Student s5 = new Student("C", 36, 81, "Female");
        Student s6 = new Student("D", 32, 97, "Male");

        List<Student> studList = Arrays.asList(s1, s2, s3, s4, s5, s6);

        Optional<Student> femaleWithThirdHighestMark =
                studList.stream()
                        .filter(s -> s.getGender().equalsIgnoreCase("FEMALE"))
                        .sorted(Comparator.comparingInt(Student::getMarks)) //Sort in descending order
                        .skip(2) //Skip the first two highest marks
                        .findFirst();

        femaleWithThirdHighestMark.ifPresent(System.out::println);

    }
}





