package com.nikolay_arifulov.forms;

import lombok.Data;

@Data
public class SignUpForm {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String dateOfBirth;
}
