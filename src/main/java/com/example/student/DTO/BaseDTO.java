package com.example.student.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseDTO {

    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;
}
