package com.example.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Getter
@Setter
@Document(collection = "Student")

public class StudentEntity extends BaseEntity {


    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String contactNumber;
    private String email;




}
