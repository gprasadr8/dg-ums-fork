package com.pw.ums.entity;

import com.pw.ums.converters.TimestampConverter;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;

@Entity(name = "DG_USER")
@Data
@Generated // to remove class from jacoco report
public class DGUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private long id;

    @NotBlank(message = "First Name is mandatory")
    @Size(min = 3, message = "First Name should contain at least 3 characters")
    @Size(max = 50, message = "First Name should not be more than 50 characters")
    private String firstName;

    private String lastName;

    @Email(message = "Invalid Email Id")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10,max=10, message = "Phone Number should contain exactly 10 digits.")
    private String phone;

    @Convert(converter = TimestampConverter.class)
    private Instant createdOn;

    @Convert(converter = TimestampConverter.class)
    private Instant updatedOn;



    private boolean active;

}
