package com.pavansai.Springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavansai.Springsecurity.model.Student;
import com.pavansai.Springsecurity.repository.StudentsRepo;

@Service
public class StudentService {

    @Autowired
    private StudentsRepo repo;

    public List<Student> getstudents() {

        return repo.getstudents();

    }

    public String addStudent(Student student) {

        return repo.addStudent(student);
    }
}
