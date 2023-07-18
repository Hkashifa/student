package com.example.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Document(collection = "Student")

public class StudentEntity extends BaseEntity {

    @Id
    @Indexed(unique = true)
    private Integer Id;

    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String contactNumber;
    private String email;




}
