package com.example.spring3project.controller;

import com.example.spring3project.model.StudentRequest;
import com.example.spring3project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<StudentRequest> createStudent(@RequestBody StudentRequest studentRequest)
    {
        StudentRequest studentRequest1=studentService.createStudent(studentRequest);
        return new ResponseEntity<>(studentRequest1, HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentRequest>> getAllStudents()
    {
        List<StudentRequest> studentRequestList=studentService.getAllStudents();
        return new ResponseEntity<>(studentRequestList,HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentRequest> getStudentById(@PathVariable Long id)
    {
        StudentRequest studentRequest=studentService.getStudentById(id);
        return new ResponseEntity<>(studentRequest,HttpStatus.OK);
    }

}
