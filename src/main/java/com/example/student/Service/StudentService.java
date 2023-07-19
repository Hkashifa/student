package com.example.student.Service;

import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface StudentService {

    List<StudentDTO> getAllStudent();
    StudentDTO getSingleStudent(@PathVariable String id);
    StudentDTO addNewStudent(@RequestBody StudentDTO student);
    StudentDTO updateStudent(@RequestBody  StudentDTO student,@PathVariable String id);

    void deleteStudent(@PathVariable String id);




}
