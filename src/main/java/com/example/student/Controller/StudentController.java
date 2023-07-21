package com.example.student.Controller;

import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import com.example.student.Service.StudentService;
import org.bson.types.ObjectId;
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

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO student,@PathVariable(name="id") String id)
    {
        StudentDTO studentResponse = studentService.updateStudent(student,id);
        return ResponseEntity.ok().body(studentResponse);

    }

    @DeleteMapping("delete/{firstName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable (name = "firstName") String firstName)
    {
        studentService.deleteStudent(firstName);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable (name = "id") String id)
    {
        studentService.deleteStudentById(id);

    }

    @GetMapping("/search")
    public List<StudentDTO> SearchBy (
            @RequestParam (required = false)String firstName,
            @RequestParam (required = false)String department,
            @RequestParam (required = false)String gender)
    {
       return studentService.SearchBy(firstName,department,gender);
    }

}
