package com.example.student.Repository;

import com.example.student.Entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentEntity,Integer> {

   public StudentEntity findById();
}
