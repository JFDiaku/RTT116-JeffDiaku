package com.example.module309.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
@Getter
@Setter
@ToString
public class CreateCustomerFormBean {
    // this is called a POJO - Plain Old Java Object
    // this object is called a FormBean
    // this is analgous to a DTO (Data Transport Object)
    // this is NEVER EVER an entity
    // the variable names here do need to match exactly what is in the name attribute on the HTML input field

    @NotEmpty(message = "Customer name is required.")
    private String CustomerName;

    @NotEmpty(message = "First name is required.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @NotEmpty(message = "Phone is required.")
    private String phone;

    @NotEmpty(message = "Customer name is required.")
    private String addressLine1;

    @NotEmpty(message = "Customer name is required.")
    private String city;

    @NotEmpty(message = "Customer name is required.")
    private String country;

}
