package com.pw.ums.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @NotBlank(message = "First Name is required")
    @Size(min = 3, message = "First Name should contain at least 3 characters")
    @Size(max = 50, message = "First Name should not be more than 50 characters")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    private String email;

}
