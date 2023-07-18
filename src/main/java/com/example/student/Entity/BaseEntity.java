package com.example.student.Entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseEntity {
    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;
}
