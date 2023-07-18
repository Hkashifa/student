package com.example.student.Controller;

import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import com.example.student.Service.StudentService;
import com.example.student.Entity.StudentEntity;
import com.example.student.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;
    @GetMapping
    public List<StudentDTO> getAllStudent(){

        return studentService.getAllStudent();

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getSingleStudent(Integer id)
    {
         StudentDTO studentDTO = studentService.getSingleStudent(id);
         return ResponseEntity.ok().body(studentDTO);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addNewStudent(@RequestBody StudentDTO studentdto)
    {
         StudentDTO studentResponse = studentService.addNewStudent(studentdto);
        return new ResponseEntity<>( studentResponse, HttpStatus.CREATED);

    }

    @PutMapping("update/{id}")
    public <ResponseEntity>StudentDTO updateStudent(@RequestBody StudentDTO studentEntity,Integer id)
    {
        studentService.updateStudent(studentEntity,id);
    }

    @DeleteMapping("delete/{id}")
    void deleteStudent(Integer id)
    {

    }

}
