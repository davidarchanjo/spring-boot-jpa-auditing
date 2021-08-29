package br.com.example.davidarchanjo.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {    
        
    private Long userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;
}
