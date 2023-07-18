package com.example.student.Service.ServiceImpl;

import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import com.example.student.Repository.StudentRepository;
import com.example.student.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMap;
    private final StudentRepository studentRepo;

    public StudentServiceImpl(ModelMapper modelMap, StudentRepository studentRepo) {
        this.modelMap = modelMap;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDTO> getAllStudent() {

        return studentRepo.findAll().stream().map(student -> modelMap.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getSingleStudent(Integer id) {
        Optional<StudentEntity> studentEntity =  studentRepo.findById(id);
        StudentDTO studentDTO = modelMap.map(studentEntity,StudentDTO.class);
        return studentDTO;
    }

    @Override
    public StudentDTO addNewStudent(StudentDTO studentEntity) {

        StudentEntity savedStudent = modelMap.map(studentEntity,StudentEntity.class);
        studentRepo.save(savedStudent);
        return studentEntity;

    }

    @Override
    public StudentDTO updateStudent(StudentDTO student,Integer id) {
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {

    }
}
