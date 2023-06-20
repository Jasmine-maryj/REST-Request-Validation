package com.dev.springvalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDTO {
    @NotEmpty
    @NotNull(message = "Username should not be null")
    private String name;

    @Email(message = "Invalid Email address")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number!")
    private String mobile;

    @NotNull
    private String gender;

    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String nationality;
}
