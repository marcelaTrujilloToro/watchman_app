package com.umanizales.watchman_app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WatchmanDTO {
    private int code;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String lastname;
    @NotNull
    @NotBlank(message = "{email.notBlank}")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4})+$", message = "{email.required}")
    private String email;
    @NotNull
    @NotEmpty
    @Size(min = 7, max = 10, message = "{telephone.size}")
    private String telephone;
}