package com.example.student.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString

public abstract class BaseEntity {


    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;
}
