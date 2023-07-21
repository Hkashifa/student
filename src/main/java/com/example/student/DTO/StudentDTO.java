package com.example.student.DTO;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor//remove this and see what happens
@AllArgsConstructor//remove this and see what happens
public class StudentDTO extends BaseDTO{

    @Id
    private String Id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String gender;
    private String department;
    private double cgpa;
}
