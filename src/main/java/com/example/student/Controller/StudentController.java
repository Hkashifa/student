package com.example.student.Controller;

import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import com.example.student.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){

        return studentService.getAllStudent();

    }

    @GetMapping("/{Id}")
    public ResponseEntity<StudentDTO> getSingleStudent(@PathVariable String Id)
    {
         StudentDTO studentDTO = studentService.getSingleStudent(Id);
         return ResponseEntity.ok().body(studentDTO);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addNewStudent(@RequestBody StudentDTO studentdto)
    {
         StudentDTO studentResponse = studentService.addNewStudent(studentdto);
        return new ResponseEntity<>( studentResponse, HttpStatus.CREATED);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO student,@PathVariable String Id)
    {
        StudentDTO studentResponse = studentService.updateStudent(student,Id);
        return ResponseEntity.ok().body(studentResponse);

    }

    @DeleteMapping("delete/{firstName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable (name = "firstName") String firstName)
    {
        studentService.deleteStudent(firstName);


    }

}
