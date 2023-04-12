package com.example.spring3project.service;

import com.example.spring3project.model.StudentRequest;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private ObservationRegistry observationRegistry;

    List<StudentRequest> studentRequestList=new ArrayList<>();

    public StudentRequest createStudent(StudentRequest studentRequest)
    {
        studentRequestList.add(studentRequest);
        return Observation.createNotStarted("createStudent",observationRegistry)
                .observe(()->studentRequest);
    }

    public List<StudentRequest> getAllStudents()
    {
        return Observation.createNotStarted("getAllStudents",observationRegistry)
                .observe(()->studentRequestList);
    }

       public StudentRequest getStudentById(Long id)
       {
       return Observation.createNotStarted("getStudentById",observationRegistry)
               .observe(()-> studentRequestList.stream().filter(studentRequest ->
                               studentRequest.id().equals(id)).findAny().orElseThrow(()
                               -> new RuntimeException("data is not found" +id)));

       }
}
