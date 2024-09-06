package com.pavansai.Springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pavansai.Springsecurity.model.Student;
import com.pavansai.Springsecurity.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("csrf")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/")
    public String start() {
        return "server starting...";
    }

    @GetMapping("students")
    public List<Student> about() {
        return service.getstudents();
    }

    @PostMapping("student")
    public String addStudent(@RequestBody Student student) {

        return service.addStudent(student);
    }

}
