package com.example.student.Service;

import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudent();
    StudentDTO getSingleStudent(Integer id);
    StudentDTO addNewStudent(@RequestBody StudentDTO studentEntity);
    StudentDTO updateStudent(@RequestBody StudentEntity studentEntity);

    void deleteStudent(Integer id);




}
