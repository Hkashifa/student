package com.example.student.Repository;

import com.example.student.Entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity,String> {

    StudentEntity deleteStudentEntityByFirstName(String firstName);

    StudentEntity deleteStudentEntityById(String id);




}
