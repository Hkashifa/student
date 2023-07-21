package com.example.student.Repository;

import com.example.student.Entity.StudentEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity,String> {

    StudentEntity deleteStudentEntityByFirstName(String firstName);
    StudentEntity deleteStudentEntityById(String id);
    List<StudentEntity> findStudentEntitiesByDepartmentEqualsAndGenderEquals(String number,String gender);
    List<StudentEntity> findStudentEntitiesByFirstNameEqualsAndGenderEquals(String name,String gender);
    List<StudentEntity> findStudentEntitiesByFirstNameEqualsAndDepartmentEquals(String firstName,String department);


    List<StudentEntity> findStudentEntitiesByFirstNameEquals(String firstName);
    List<StudentEntity> findStudentEntitiesByGenderEquals(String gender);
    List<StudentEntity> findStudentEntitiesByDepartmentEquals(String department);

    List<StudentEntity> findStudentEntitiesByFirstNameEqualsAndDepartmentEqualsAndGenderEquals(String firstName,String department,String gender);

    }

