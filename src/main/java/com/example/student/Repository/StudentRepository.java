package com.example.student.Repository;

import com.example.student.Entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity,String> {

    StudentEntity deleteStudentEntityByFirstName(String firstName);


}
