package com.example.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Getter
@Setter
@Document(collection = "Student")

public class StudentEntity extends BaseEntity {

    @Id
    @Indexed(unique = true)
    private String id;

    private String firstName;
    private String lastName;

    private String contactNumber;
    private String email;

    private String gender;
    private String department;
    private double cgpa;




}
