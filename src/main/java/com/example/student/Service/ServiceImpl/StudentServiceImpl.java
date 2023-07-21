package com.example.student.Service.ServiceImpl;

import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.StudentEntity;
import com.example.student.Repository.StudentRepository;
import com.example.student.Service.StudentService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    public StudentDTO getSingleStudent(String Id) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(Id);
        StudentDTO studentDTO = modelMap.map(studentEntity, StudentDTO.class);
        return studentDTO;
    }

    @Override
    public StudentDTO addNewStudent(@RequestBody StudentDTO studentEntity) {

        StudentEntity savedStudent = modelMap.map(studentEntity, StudentEntity.class);
        studentRepo.save(savedStudent);
        StudentDTO returnedStudent = modelMap.map(savedStudent, StudentDTO.class);
        return returnedStudent;

    }

    @Override
    public StudentDTO updateStudent(StudentDTO student, String id) {

        StudentEntity updatedStudent = modelMap.map(student, StudentEntity.class);
        Optional<StudentEntity> oldStudentOptional = studentRepo.findById(id);

        if (oldStudentOptional.isPresent()) {
            StudentEntity oldStudent = oldStudentOptional.get();
                oldStudent.setFirstName(updatedStudent.getFirstName());
                oldStudent.setLastName(updatedStudent.getLastName());
                oldStudent.setContactNumber(updatedStudent.getContactNumber());
                oldStudent.setEmail(updatedStudent.getEmail());

            studentRepo.save(oldStudent);
            StudentDTO studentResponse = modelMap.map(oldStudent, StudentDTO.class);
            return studentResponse;


        } else {
            throw new IllegalArgumentException("Student not found with ID: " + id);
        }
    }

    @Override
    public void deleteStudent(String firstName) {

        studentRepo.deleteStudentEntityByFirstName(firstName);

    }

    @Override
    public void deleteStudentById(String id) {

    studentRepo.deleteStudentEntityById(id);


    }

//    @Override
    public List<StudentDTO> SearchBy(String firstName, String department, String gender) {



        if(firstName == null && department== null)
        {
            return studentRepo.findStudentEntitiesByGenderEquals(gender)
                    .stream().map(student -> modelMap.map(student, StudentDTO.class)).collect(Collectors.toList());
        }
        else if(department == null && gender == null)
        {
            return studentRepo.findStudentEntitiesByFirstNameEquals(firstName)
                    .stream().map(student -> modelMap.map(student, StudentDTO.class)).collect(Collectors.toList());
        }
        else if(gender == null && firstName == null)
        {
            return studentRepo.findStudentEntitiesByDepartmentEquals(department)
                    .stream().map(student -> modelMap.map(student, StudentDTO.class)).collect(Collectors.toList());
        }
        else if(firstName == null)
        {
            return studentRepo.findStudentEntitiesByDepartmentEqualsAndGenderEquals(department,gender).stream().map(student-> modelMap.map(student, StudentDTO.class))
                    .collect(Collectors.toList());
        }
        else if(department == null)
        {
            return studentRepo.findStudentEntitiesByFirstNameEqualsAndGenderEquals(firstName,gender).
                    stream().map(student -> modelMap.map(student, StudentDTO.class)).collect(Collectors.toList());
        }
        else if(gender == null)
        {
            return studentRepo.findStudentEntitiesByFirstNameEqualsAndDepartmentEquals(firstName,department)
                    .stream().map(student -> modelMap.map(student, StudentDTO.class)).collect(Collectors.toList());
        }
        else
        {
            return studentRepo.findStudentEntitiesByFirstNameEqualsAndDepartmentEqualsAndGenderEquals(firstName,department,gender)
                    .stream().map(student -> modelMap.map(student,StudentDTO.class)).collect(Collectors.toList());
        }

    }

//    @Override
//    public double averageCgpa() {
//        return studentRepo.averageCgpa();
//    }


}
