package com.pavansai.Springsecurity.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pavansai.Springsecurity.model.Student;

@Repository
public class StudentsRepo {

    List<Student> students = new ArrayList<>(
            Arrays.asList(new Student(1, "pavansai", "java"), new Student(2, "dino", "node"),
                    new Student(3, "kaviti", "UI/UX")));

    public List<Student> getstudents() {
        return students;
    }

    public String addStudent(Student student) {
        students.add(student);
        return "Student added";
    }

}
